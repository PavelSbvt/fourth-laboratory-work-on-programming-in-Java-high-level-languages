package ru.sablin.lab4.models;

import ru.sablin.lab4.utils.OutputFunctions;


/**
 * Абстрактный базовый класс банковского счёта.
 * Содержит общие для всех счетов поля (идентификатор и баланс)
 * и общие операции (пополнение, снятие)
 */
public abstract class Account {
    private Integer accountId;
    private double balance;

    public Account(Integer accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public Integer getAccountId() { return accountId; }
    public double getBalance()    { return balance; }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public abstract String getAccountType();

    public abstract void showInfo();

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
    }

    protected void setBalance(double balance) { this.balance = balance; }
}
