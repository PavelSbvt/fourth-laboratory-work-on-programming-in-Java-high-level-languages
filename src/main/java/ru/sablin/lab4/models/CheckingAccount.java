package ru.sablin.lab4.models;

import ru.sablin.lab4.utils.OutputFunctions;


/**
 * Текущий счёт — с возможностью ухода в минус (овердрафт).
 */
public class CheckingAccount extends Account {
    /** Лимит овердрафта — допустимый уход в минус по счёту */
    private double overdraftLimit;

    /**Конструктор*/
    public CheckingAccount(Integer accountId, double balance) {
        this(accountId, balance, 0.0);
    }

    /**Перегруженный конструктор*/
    public CheckingAccount(Integer accountId, double balance, double overdraftLimit) {
        super(accountId, balance);
        this.overdraftLimit = overdraftLimit;
    }

    /**Геттер для получения лимита ухода в минус*/
    public double getOverdraftLimit() { return overdraftLimit; }

    /**Сеттер для установки лимита на уход в минус*/
    public void setOverdraftLimit(double overdraftLimit) { this.overdraftLimit = overdraftLimit; }

    /**Переписанный (изменённый) метод родительского класса для получения типа счёта*/
    @Override
    public String getAccountType() {
        return "Текущий";
    }


    @Override
    public void withdraw(double amount) {
        if (amount <= 0) return;
        if (getBalance() - amount < -overdraftLimit) {
            OutputFunctions.warningLog("Превышен лимит овердрафта");
            return;
        }
        setBalance(getBalance() - amount); // уходим в минус в пределах лимита
    }

    /**Функция для вывода информации по текущему счёту*/
    @Override
    public void showInfo() {
        OutputFunctions.simpleLog("Тип счёта: " + getAccountType());
        OutputFunctions.simpleLog("ID счёта: " + getAccountId());
        OutputFunctions.simpleLog("Баланс: " + getBalance());
        OutputFunctions.simpleLog("Лимит овердрафта: " + overdraftLimit);
    }
}