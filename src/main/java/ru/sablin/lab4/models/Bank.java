package ru.sablin.lab4.models;

import ru.sablin.lab4.utils.OutputFunctions;

/**
 * Класс для описания банка (название компании и прочее)
 * Дефолтно указана информация о СберБанке
 */
public class Bank {
    /*Название банковской компании*/
    private String bankName = "ПАО СберБанк";
    /*Краткое описание банка*/
    private String shortAnnotation = "ПАО СберБанк — это крупнейший банк в " +
            "России и один из ведущих финансовых институтов Центральной" +
            " и Восточной Европы.";
    /*Юридический адрес (головной офис)*/
    private String generalOffice = "г. Москва, ул. Вавилова, д.19";
    /*адрес выбранного отделения банка*/
    private String addressOfTheSelectedBankBranch = "головной офис";
    /*дата основания*/
    private String dataOfFoundation = "12 ноября 1841 года";
    /*Лицензия*/
    private String licence = "Генеральная лицензия Банка России № 1481 от 11.08.2015";
    /*руководитель*/
    private String director = "Герман Граф";

    /*Геттеры*/
    public String getBankName (){
        return this.bankName;
    }

    public String getShortAnnotation(){
        return this.shortAnnotation;
    }

    public String getGeneralOffice (){
        return this.generalOffice;
    }

    public String getAddressOfTheSelectedBankBranch (){
        return this.addressOfTheSelectedBankBranch;
    }

    public String getDataOfFoundation (){
        return this.dataOfFoundation;
    }

    public String getLicence (){
        return this.licence;
    }

    public String getDirector (){
        return this.director;
    }

    /*Сеттеры*/


    /*Вывод информации о банковском отделении*/
    void showInfoAboutCurrentBankBranch (){
        OutputFunctions.simpleLog(
                "Вывод информации о выбранном банковском отделении");


    }
}
