package com.company;

public class Main {

    public static void main(String[] args) {
        WorkClass workclass = new WorkClass();
        workclass.readJson();
        if (workclass.isReadJson()) workclass.readJson();
        workclass.printCompanies();
        workclass.printQuery();
        if (workclass.isCorrectQuery()) workclass.printQuery();
    }
}
