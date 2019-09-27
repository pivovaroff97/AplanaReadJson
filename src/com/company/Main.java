package com.company;

public class Main {

    public static void main(String[] args) {
        WorkClass workclass = new WorkClass();
        while (!workclass.isReadFile() && !workclass.isExit()) { //print 'exit' to finish program
            workclass.readJson();
            while (workclass.isReadFile()) //print 'exit' to exit from file
                workclass.printQuery();
        }
    }
}
