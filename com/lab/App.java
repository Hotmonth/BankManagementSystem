package com.lab;

import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("Hello, manager! Please log in to use the system:");
        Scanner scan = new Scanner(System.in);
        Manager manager = new Manager();
        while (true) {
            System.out.println("Please enter a username: ");
            String username = scan.nextLine();
            System.out.println("Please enter a password: ");
            String password = scan.nextLine();
            manager.login(username, password);
            if (manager.getLoggedIn()) break;
            else {
                System.out.println("Wrong username or password. Try again.");
            }
        }
        System.out.println("Welcome to the system!");
        while (manager.getLoggedIn()) {
            info();
            Integer balance;
            int code = scan.nextInt();
        
            switch (code) {
                case 1:
                    System.out.print("Please enter a name for your account: ");
                    String name = scan.next();
                    System.out.println("Please enter a duration of your account in months: ");
                    Integer duration = scan.nextInt();
                    manager.createBankAccount(name, duration);
                    System.out.println("Account was successfully created!");
                    break;
                case 2:
                    manager.printAllAccounts();
                    break;
                case 3:
                    manager.printAllAccounts();
                    System.out.print("Type an account id to replenish balance: ");
                    int id = scan.nextInt();
                    System.out.println("Type amount of balance to replenish: ");
                    balance = scan.nextInt();
                    manager.replenishBalance(id, balance);
                    break;
                case 4:
                    manager.printAllAccounts();
                    System.out.println("Type a [sender_id] and [reciever_id] space seperated(Example: 1 2).");
                    int sender_id = scan.nextInt();
                    int reciever_id = scan.nextInt();
                    System.out.println("Type amount of balance to send: ");
                    balance = scan.nextInt();
                    manager.sendBalance(sender_id, reciever_id, balance);
                    break;
                case 5:
                    manager.logout();
                    break;

            }
        }
        scan.close();

        
    }

    public void info() {
        System.out.println("Enter Your menu choice [1 - 6]: ");
        System.out.println("1: Create bank account");
        System.out.println("2: Print all accounts");
        System.out.println("3: Replenish the balance");
        System.out.println("4: Send balance to another");
        System.out.println("5: Log out");
    }
}
