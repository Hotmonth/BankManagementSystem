package com.lab;

import java.util.Random;

public class BankAccount {
    private String name;
    private String number;
    private Integer duration;
    private Integer balance;

    BankAccount(String name, Integer duration) {
        setBankAccountName(name);
        setBankAccountDuration(duration);
        setBankAccountBalance(0);
        setBankAccountNumber();
    }

    public void setBankAccountName(String name) {
        this.name = name;
    }

    public void setBankAccountDuration(Integer duration) {
        this.duration = duration;
    }

    public void setBankAccountBalance(Integer balance) {
        this.balance = balance;
    }

    public void setBankAccountNumber() {
        this.number = generateNumber();
    }

    public String getBankAccountName() {
        return name;
    }

    public String getBankAccountNumber() {
        return number;
    }

    public Integer getBankAccountDuration() {
        return duration;
    }

    public Integer getBankAccountBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                    "name = '" + name + "\'" +
                    ", number = '" + number + "\'" +
                    ", duration = " + duration +
                    ", balance = " + balance + " }";
    }

    public String generateNumber()
    {
        String start = "KZ";
        Random value = new Random();

        int r1 = value.nextInt(10);
        int r2 = value.nextInt(10);
        start += Integer.toString(r1) + Integer.toString(r2) + " ";

        int count = 0;
        int n = 0;
        for (int i = 0; i < 14; i++) 
        {
            if (count == 4) {
                start += " ";
                count = 0;
            }
            else {
                n = value.nextInt(10);
                start += Integer.toString(n);
                count++;
            }
        }

        return start;
    }
}
