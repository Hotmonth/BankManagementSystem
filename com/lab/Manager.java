package com.lab;

import java.util.ArrayList;

public class Manager {
    final String USERNAME = "manager";
    final String PASSWORD = "12345";
    private static boolean loggedIn = false;
    ArrayList<BankAccount> accounts = new ArrayList<>();

    Manager() {

    }

    public void login(String username, String password) {
        loggedIn = this.USERNAME.equals(username) && this.PASSWORD.equals(password);
    }

    public void logout() {
        loggedIn = false;
    }

    public boolean getLoggedIn() {
        return loggedIn;
    }

    public void createBankAccount(String name, Integer duration) {
        BankAccount account = new BankAccount(name, duration);
        accounts.add(account);
    }

    public void printAllAccounts() {
        for (int i = 0; i < accounts.size(); i++)
        {
            System.out.println(i + ": " + accounts.get(i).toString());
        }
    }

    public void replenishBalance(int bankAccountId, Integer balance) {
        BankAccount account = accounts.get(bankAccountId);
        account.setBankAccountBalance(account.getBankAccountBalance() + balance);
        accounts.set(bankAccountId, account);
    }

    public void sendBalance(int senderId, int recieverId, Integer balance) {
        this.replenishBalance(senderId, -balance);
        this.replenishBalance(recieverId, balance);
    }

}
