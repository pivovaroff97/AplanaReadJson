package com.company;

public class Main {

    public static void main(String[] args) {
        WorkClass workclass = new WorkClass();
        workclass.readJson();
        if (workclass.isSecondTry()) workclass.readJson();
        workclass.printCompanies();
        workclass.printQuery();
    }
}
