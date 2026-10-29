package ru.sablin.lab4.models;

import ru.sablin.lab4.utils.OutputFunctions;


/**класс для инвестиционного счёта*/
public class InvestmentAccount extends Account {
    /**Атрибут для указания уровня риска для инвестиций*/
    private String riskLevel;

    /**Конструктор*/
    public InvestmentAccount(Integer id, double balance) {
        this(id, balance, "Средний");
    }

    /**Перегруженный конструктор*/
    public InvestmentAccount(Integer id, double balance, String risk) {
        super(id, balance);
        this.riskLevel = risk;
    }

    /**Функция для получения уровня риска*/
    public String getRiskLevel() { return riskLevel; }
    /**Функция для установления уровня риска*/
    public void setRiskLevel(String riskLevel) { this.riskLevel = riskLevel; }

    /**Переписанный (изменённый) метод родительского класса для получения типа счёта*/
    @Override public String getAccountType() { return "Инвестиционный"; }

    /**Функция для вывода информации по инвестиционному счёту*/
    @Override public void showInfo() {
        OutputFunctions.simpleLog("Тип счёта: " + getAccountType());
        OutputFunctions.simpleLog("ID счёта: " + getAccountId());
        OutputFunctions.simpleLog("Баланс: " + getBalance());
        OutputFunctions.simpleLog("Уровень риска: " + riskLevel);
    }
}