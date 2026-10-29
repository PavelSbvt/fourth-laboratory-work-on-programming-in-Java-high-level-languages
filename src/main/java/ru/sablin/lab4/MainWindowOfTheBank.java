package ru.sablin.lab4;

import ru.sablin.lab4.models.Account;
import ru.sablin.lab4.models.Bank;

import javax.swing.*;

public class MainWindowOfTheBank {


    private JPanel mainContentPanel;
    private JComboBox comboBoxAccounts;
    private JPanel panelForButtons;
    private JButton buttonPush100;
    private JButton buttonMinus50;
    private JButton buttonShowAll;
    private JTextArea textArea1;
    private JLabel processing;

    /** Банк, с которым работает окно */
    private Bank bank;

    /**
     * Конструктор: подключает обработчики к кнопкам и комбобоксу.
     */
    public MainWindowOfTheBank() {
        textArea1.setEditable(false);
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);

        comboBoxAccounts.addActionListener(e -> onAccountSelected());
        buttonPush100.addActionListener(e -> onDeposit());
        buttonMinus50.addActionListener(e -> onWithdraw());
        buttonShowAll.addActionListener(e -> onShowAll());
    }

    /**
     * Функция для получения панели с Gui-элементами
     *
     * @return возвражает объект JPanel, который содержит все виджеты окна,
     * созданные в Swing Designer
     */
    public JPanel getContentPane() {
        return mainContentPanel;
    }

    /**
     * Привязывает банк к окну и заполняет список счетов.
     *
     * @param bank отделение банка, счета которого нужно отображать
     */
    public void bindBank(Bank bank) {
        this.bank = bank;
        refreshCombo();
        if (!bank.getAccounts().isEmpty()) {
            comboBoxAccounts.setSelectedIndex(0);
            showDetails(bank.getAccounts().get(0));
        }
        processing.setText("Банк привязан. Счетов: " + bank.getAccounts().size());
    }

    /** Перезаполняет выпадающий список счетов */
    private void refreshCombo() {
        comboBoxAccounts.removeAllItems();
        if (bank == null) return;
        for (Account a : bank.getAccounts()) {
            comboBoxAccounts.addItem("[" + a.getAccountId() + "] "
                    + a.getAccountType() + " — " + a.getBalance());
        }
    }

    /** Возвращает выбранный счёт (или null) */
    private Account getSelectedAccount() {
        if (bank == null) return null;
        int idx = comboBoxAccounts.getSelectedIndex();
        if (idx < 0 || idx >= bank.getAccounts().size()) return null;
        return bank.getAccounts().get(idx);
    }

    /** Показать подробности счёта в textArea1 */
    private void showDetails(Account account) {
        if (account == null) { textArea1.setText(""); return; }
        StringBuilder sb = new StringBuilder();
        sb.append("Тип: ").append(account.getAccountType()).append("\n");
        sb.append("ID: ").append(account.getAccountId()).append("\n");
        sb.append("Баланс: ").append(account.getBalance()).append("\n");
        textArea1.setText(sb.toString());
    }

    /** Обработчик выбора счёта в комбобоксе */
    private void onAccountSelected() {
        Account a = getSelectedAccount();
        showDetails(a);
        processing.setText(a == null ? "Счёт не выбран"
                : "Выбран счёт #" + a.getAccountId());
    }

    /** Обработчик кнопки «Пополнить +100» */
    private void onDeposit() {
        Account a = getSelectedAccount();
        if (a == null) { processing.setText("Счёт не выбран"); return; }
        a.deposit(100);
        refreshCombo();
        selectById(a.getAccountId());
        showDetails(a);
        processing.setText("Пополнено на 100. Баланс: " + a.getBalance());
    }

    /** Обработчик кнопки «Снять 50» */
    private void onWithdraw() {
        Account a = getSelectedAccount();
        if (a == null) { processing.setText("Счёт не выбран"); return; }
        double before = a.getBalance();
        a.withdraw(50);
        refreshCombo();
        selectById(a.getAccountId());
        showDetails(a);
        if (a.getBalance() == before) {
            processing.setText("Снятие не выполнено (недостаточно средств или овердрафт)");
        } else {
            processing.setText("Снято 50. Баланс: " + a.getBalance());
        }
    }

    /** Обработчик кнопки «Показать всё» */
    private void onShowAll() {
        if (bank == null) return;
        StringBuilder sb = new StringBuilder();
        for (Account a : bank.getAccounts()) {
            sb.append("Тип: ").append(a.getAccountType())
                    .append(", ID: ").append(a.getAccountId())
                    .append(", баланс: ").append(a.getBalance())
                    .append("\n");
        }
        textArea1.setText(sb.toString());
        processing.setText("Показаны все счета (" + bank.getAccounts().size() + ")");
        bank.showAllAccounts(); // дублируем в консоль — наглядный полиморфизм (п.8)
    }

    /** Восстанавливает выбор в комбобоксе по id счёта */
    private void selectById(Integer id) {
        if (bank == null) return;
        for (int i = 0; i < bank.getAccounts().size(); i++) {
            if (bank.getAccounts().get(i).getAccountId().equals(id)) {
                comboBoxAccounts.setSelectedIndex(i);
                return;
            }
        }
    }
}
