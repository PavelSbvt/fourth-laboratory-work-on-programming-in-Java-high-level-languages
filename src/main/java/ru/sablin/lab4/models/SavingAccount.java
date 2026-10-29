package ru.sablin.lab4.models;

import ru.sablin.lab4.utils.OutputFunctions;


/**
 * Сберегательный счёт — с начислением процентов.
 */
public class SavingAccount extends Account {
    /** Процентная ставка, % годовых*/
    private double interestRate;

    /** Перегруженный конструктор №1: ставка по умолчанию */
    public SavingAccount(Integer accountId, double balance) {
        this(accountId, balance, 5.0);
    }

    /** Перегруженный конструктор №2: явная ставка */
    public SavingAccount(Integer accountId, double balance, double interestRate) {
        super(accountId, balance);
        this.interestRate = interestRate;
    }

    /**Функция для получения процентной ставки накоплений (%)*/
    public double getInterestRate() { return interestRate; }

    /**Функция для установки процентной ставки накоплений*/
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }

    /** Уникальный метод подкласса */
    public double calculateInterest() {
        return getBalance() * interestRate / 100.0;
    }

    /**Переписанный (изменённый) метод родительского класса для получения типа счёта*/
    @Override
    public String getAccountType() {
        return "Сберегательный";
    }

    /**Изменённая функция родительского класса для вывода информации о счёте*/
    @Override
    public void showInfo() {
        OutputFunctions.simpleLog("Тип счёта: " + getAccountType());
        OutputFunctions.simpleLog("ID счёта: " + getAccountId());
        OutputFunctions.simpleLog("Баланс: " + getBalance());
        OutputFunctions.simpleLog("Процентная ставка: " + interestRate + "%");
        OutputFunctions.simpleLog("Начисленные проценты: " + calculateInterest());
    }
}