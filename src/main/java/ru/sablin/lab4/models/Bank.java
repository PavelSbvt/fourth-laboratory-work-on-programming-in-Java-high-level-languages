package ru.sablin.lab4.models;

import ru.sablin.lab4.utils.OutputFunctions;

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
    }

    public Bank (Integer bankID, String bankDirector, String bankAddress){
        this.bankDirector = bankDirector;
        this.currentBankID = bankID;
        this.bankAddress = bankAddress;
    }
}
