package com.company;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {SimpleBank bank = SimpleBank.getInstance();
        try {
            bank.showAccounts();
            bank.add(   100_001, 100.00);
            bank.add(   100_023, 300.00);
            bank.add(   100_034, 200.00);
            bank.payOff(100_001,  60.50);
            bank.add(   100_045, 120.30);
            Thread.sleep(900);
            bank.payOff(100_001,  15.20);
        }
        catch(Exception ex) {
            ex.getMessage();
        }
        // wyswietlamy stan kont po wykonaniu wszystkich operacji
        bank.showAccounts();
        // wyswietlamy zrealizowane transakcje
        bank.showTransactions();
    }
}

