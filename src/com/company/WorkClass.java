package com.company;

import com.google.gson.Gson;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;

public class WorkClass {

    private Company[] company;
    private boolean isSecondTry;

    public void readJson() {
        System.out.println("Введите путь к файлу");
        Gson g = new Gson();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader bufferedReader = new BufferedReader(new FileReader(reader.readLine()));
            company = g.fromJson(bufferedReader, Company[].class);
        }
        catch (FileNotFoundException e) {
            if (!isSecondTry) System.out.println("Файл не найден, попробуйте снова");
            else System.out.println("Файл не найден");
            isSecondTry = true;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printCompanies() {
        for (Company com : company) {
            System.out.println(com.toString());
            com.getSecurities().stream().filter(s -> s.
                    isBefore(LocalDate.now(), LocalDate.parse(s.getDateTo()))).forEach(System.out::println);
            System.out.println("Просроченных ценных бумаг: " + com.getSecurities().stream().filter(s -> s.
                    isBefore(LocalDate.now(), LocalDate.parse(s.getDateTo()))).count());
        }
    }

    public void printQuery() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String userQuery = bufferedReader.readLine();
            if (Arrays.stream(Currencies.values()).anyMatch(s -> s.toString().equals(userQuery))) {
                for (Company com : company) {
                    com.getSecurities().stream().
                            filter(s -> (s.getCurrency().isCurrency(userQuery))).forEach(System.out::println);
                }
            } else {
                String[] str = userQuery.split("[,./]");
                String date = "";
                for (int i = str.length - 1; i >= 0; i--) {
                    date += str[i];
                    if (i != 0) date += "-";
                }
                LocalDate userDate = LocalDate.parse(date);
                Arrays.stream(company).filter(s -> s.
                        isBefore(userDate, LocalDate.parse(s.getEgrulDate()))).forEach(System.out::println);
            }
        }
        catch (Exception e) {
            System.out.println("Некорректный запрос");
        }
    }

    public Company[] getCompany() {
        return company;
    }

    public void setCompany(Company[] company) {
        this.company = company;
    }

    public boolean isSecondTry() {
        return isSecondTry;
    }

    enum Currencies {
        JPY, CNY, SDG, RON, MKD, MXN, CAD, ZAR, AUD, NOK, ILS, ISK,
        SYP, LYD, UYU, YER, CSD, EEK, THB, IDR, LBP, AED, BOB, QAR,
        BHD, HNL, HRK, COP, ALL, DKK, MYR, SEK, RSD, BGN, DOP, KRW,
        LVL, VEF, CZK, TND, KWD, VND, JOD, NZD, PAB, CLP, PEN, GBP,
        DZD, CHF, RUB, UAH, ARS, SAR, EGP, INR, PYG, TWD, TRY, BAM,
        OMR, SGD, MAD, BYR, NIO, HKD, LTL, SKK, GTQ, BRL, EUR, HUF,
        IQD, CRC, PHP, SVC, PLN, USD
    }
}

