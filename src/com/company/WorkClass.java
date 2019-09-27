package com.company;

import com.google.gson.Gson;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;

public class WorkClass {

    private Company[] company;
    private boolean isReadFile;
    private boolean isExit;

    public void readJson() {
        System.out.println("Введите путь к файлу:");
        String filename = "";
        Gson g = new Gson();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            filename = reader.readLine();
            if (filename.equals("exit")) {
                isExit = true;
                return;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            company = g.fromJson(bufferedReader, Company[].class);
            isReadFile = true;
            printCompanies();
        }
        catch (FileNotFoundException e) {
            System.out.println("Файл не найден, попробуйте снова");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printCompanies() {
        long companySec = 0;
        long allSec = 0;
        for (Company com : company) {
            System.out.println(com.toString());
            com.getSecurities().stream().filter(s -> s.
                    isBefore(LocalDate.now(), LocalDate.parse(s.getDateTo()))).forEach(System.out::println);
           companySec = com.getSecurities().stream().filter(s -> s.
                    isBefore(LocalDate.now(), LocalDate.parse(s.getDateTo()))).count();
            System.out.println("Просроченных ценных бумаг в компании " + com.getNameShort() + ": "
                    + companySec);
            allSec += companySec;
        }
        System.out.println("Общее количество просроченных бумаг: " + allSec);
    }

    public void printQuery() {
        System.out.println("Введите дату или валюту:");
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String userQuery = bufferedReader.readLine();
            if (userQuery.equals("exit")) {
                isReadFile = false;
                return;
            }
            if (Arrays.stream(company).anyMatch(s -> s.getSecurities().
                    stream().anyMatch(x -> x.getCurrency().getCode().equals(userQuery)))) {
                for (Company com : company) {
                    com.getSecurities().stream().
                            filter(s -> (s.getCurrency().isCurrency(userQuery))).forEach(System.out::println);
                }
            } else {
                String[] str = userQuery.split("[,./]");
                StringBuilder date = new StringBuilder();
                for (int i = str.length - 1; i >= 0; i--)
                    date.append(str[i]);
                SimpleDateFormat parser;
                if (date.length() == 6) parser = new SimpleDateFormat("yyMMdd");
                else parser = new SimpleDateFormat("yyyyMMdd");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                LocalDate userDate = LocalDate.parse(formatter.format(parser.parse(date.toString())));
                Arrays.stream(company).filter(s -> s.
                        isBefore(userDate, LocalDate.parse(s.getEgrulDate()))).forEach(System.out::println);
            }
        }
        catch (Exception e) {
            System.out.println("Некорректный запрос, попробуйте снова");
        }
    }

    public Company[] getCompany() {
        return company;
    }

    public void setCompany(Company[] company) {
        this.company = company;
    }

    public boolean isReadFile() {
        return isReadFile;
    }

    public boolean isExit() {
        return isExit;
    }
}

