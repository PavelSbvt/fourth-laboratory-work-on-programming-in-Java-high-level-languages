package ru.sablin.lab4;

import ru.sablin.lab4.utils.OutputFunctions;
import ru.sablin.lab4.models.Bank;
import ru.sablin.lab4.models.Account;
import ru.sablin.lab4.models.CheckingAccount;
import ru.sablin.lab4.models.SavingAccount;
import ru.sablin.lab4.models.InvestmentAccount;


import javax.swing.*;

public class Main {
    /**Функция для создания и работы с окном интерфейса**/
    public static MainWindowOfTheBank createWindowUI(){
        JFrame frame = new JFrame("Система управления банком");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainWindowOfTheBank form = new MainWindowOfTheBank();

        frame.setContentPane(form.getContentPane());
        JPanel content = form.getContentPane();

        JScrollPane scroll = new JScrollPane(content);

        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.getHorizontalScrollBar().setUnitIncrement(16);

        frame.setContentPane(scroll);

        frame.setSize(1250, 900);
        frame.setMinimumSize(new java.awt.Dimension(500, 400));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        return form;
    }


    public static void main(String[] args) {
        OutputFunctions.simpleLog("Запуск программы");
        OutputFunctions.spacerPoints();

        MainWindowOfTheBank mainWindow = createWindowUI();

//        Создание банка
        Bank bank = new Bank(1001, "Виталий Носов", "г. Тамбов, ул. Бориса Васильева, д. 12");
        bank.showInfoAboutGeneralBank();
        bank.showInfoAboutCurrentBankBranch();

//        Создание объектов счетов
        Account a1 = new CheckingAccount(101, 1000, 500);
        Account a2 = new SavingAccount (102, 5000, 7.5);
        Account a3 = new SavingAccount (103, 250.3);
        Account a4 = new InvestmentAccount(104, 20000, "Высокий");

//      Добавление счетов в банк
        bank.addAccount(a1);
        bank.addAccount(a2);
        bank.addAccount(a3);
        bank.addAccount(a4);

        mainWindow.bindBank(bank);

//      Функции
        bank.showInfoAboutCurrentBankBranch();

        bank.showAllAccounts();
    }
}
