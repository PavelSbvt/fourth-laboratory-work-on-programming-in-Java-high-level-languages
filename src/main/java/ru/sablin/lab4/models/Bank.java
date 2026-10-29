package ru.sablin.lab4.models;

import ru.sablin.lab4.utils.OutputFunctions;

import java.util.ArrayList;
import java.util.List;


/**
 * Класс для описания банка
 */
public class Bank {
    /**Идентификационный номер отделения банка*/
    private Integer currentBankID;
    /**Директор отделения банка*/
    private String bankDirector;
    /**Адрес отделения*/
    private String bankAddress;

    /** Счета, открытые в этом отделении */
    private final List<Account> accounts = new ArrayList<>();

    /*Геттеры*/
    /**Функция получения id отделения банка*/
    public Integer getCurrentBankID (){
        return this.currentBankID;
    }

    /**Функция получения имени директора отделения банка*/
    public String getCurrentBankDirector(){
        return this.bankDirector;
    }

    /**Функция для получения адреса отделения банка*/
    public String getCurrentBankAddress(){
        return this.bankAddress;
    }

    /*Сеттеры*/
    /**Функция для установления смены директора отделения банка (смена имени)*/
    public void setCurrentBankDirector (String inputCurrentBankDirector){
        this.bankDirector = inputCurrentBankDirector;
    }

    /*Функции*/
    /** Добавить счёт в отделение */
    public void addAccount(Account account) {
        if (account == null) return;
        accounts.add(account);
        OutputFunctions.debugLog("Счёт " + account.getAccountId()
                + " добавлен в отделение " + currentBankID);
    }

    /** Удалить счёт по id */
    public boolean removeAccount(Integer accountId) {
        boolean removed = accounts.removeIf(a -> a.getAccountId().equals(accountId));
        if (removed) {
            OutputFunctions.debugLog("Счёт " + accountId + " удалён");
        }
        return removed;
    }

    /** Найти счёт по id (или null, если нет) */
    public Account findAccount(Integer accountId) {
        for (Account a : accounts) {
            if (a.getAccountId().equals(accountId)) return a;
        }
        return null;
    }

    /** Список всех счетов отделения */
    public List<Account> getAccounts() {
        return accounts;
    }

    /** Вывести информацию обо всех счетах отделения (полиморфный вызов) */
    public void showAllAccounts() {
        OutputFunctions.spacerPoints();
        OutputFunctions.simpleLog("Счета отделения №" + currentBankID + ":");
        if (accounts.isEmpty()) {
            OutputFunctions.warningLog("В отделении пока нет счетов");
            return;
        }
        for (Account account : accounts) {
            account.showInfo();          // вызовется версия из подкласса
            OutputFunctions.spacerPoints();
        }
    }

    /**Функция для смены адреса отделения банка*/
    public void setCurrentBankAddress(String inputAddress){
        this.bankAddress = inputAddress;
    }

    /**Вывод информации о главном отделении банка*/
    public void showInfoAboutGeneralBank(){
        /*Заголовок*/
        String title = "Информация о организации";
        OutputFunctions.simpleLog(title);
        OutputFunctions.spacerPoints();

        /*Название банковской компании*/
        String bankName = "Название организации: ПАО СберБанк";
        /*Краткое описание банка*/
        String shortAnnotation = "Описание: ПАО СберБанк — это крупнейший банк в " +
                "России и один из ведущих финансовых институтов Центральной" +
                " и Восточной Европы.";
        /*Юридический адрес (головной офис)*/
        String generalOffice = "Адрес главного отделения: г. Москва, ул. Вавилова, д.19";
        /*дата основания*/
        String dataOfFoundation = "Дата основания: 12 ноября 1841 года";
        /*Лицензия*/
        String licence = "Лицензия: Генеральная лицензия Банка России № 1481 от 11.08.2015";
        /*руководитель*/
        String director = "Генеральный директор: " + this.bankDirector;

        OutputFunctions.simpleLog(bankName);
        OutputFunctions.simpleLog(shortAnnotation);
        OutputFunctions.simpleLog(generalOffice);
        OutputFunctions.simpleLog(dataOfFoundation);
        OutputFunctions.simpleLog(licence);
        OutputFunctions.simpleLog(director);
    }

    /**Вывод информации о банковском отделении*/
    public void showInfoAboutCurrentBankBranch (){
        OutputFunctions.simpleLog(
                "Вывод информации о выбранном банковском отделении");
        OutputFunctions.spacerPoints();

        OutputFunctions.simpleLog("ID отделения: " + this.currentBankID);
        OutputFunctions.simpleLog("Директор: " + this.bankDirector);
        OutputFunctions.simpleLog("Количество счетов: " + accounts.size());

        OutputFunctions.spacerPoints();
    }

    /**Конструктор*/
    public Bank (Integer bankID, String bankDirector, String bankAddress){
        this.bankDirector = bankDirector;
        this.currentBankID = bankID;
        this.bankAddress = bankAddress;
    }
}
