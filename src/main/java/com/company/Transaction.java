package com.company;

import java.time.LocalDateTime;

/**
 * Klasa do rejestrowania kazdej operacji dokonywanej w banku SimpleBank
 */

public class Transaction {

    /**
     * Kontruktor obiektu klasy Transaction
     * @param accountNumber numer konta bankowego
     * @param date data transakcji
     * @param operation rodzaj operacji bankowej
     * @param amount kwota transakcji
     */
    public Transaction(int accountNumber, LocalDateTime date, BankOperation operation, double amount) {
        this.accountNumber = accountNumber;
        this.date = date;
        this.operation = operation;
        this.amount = amount;
    }

    /**
     * Metoda getAccountNumber pobiera numer danego konta bankowego
     * @return numer konta bankowego
     */

    public int getAccountNumber() {
        return accountNumber;
    }

    public LocalDateTime getDate() {
        return date;
    }

    /**
     * numer konta
     */
    private int accountNumber;
    private LocalDateTime date;
    private BankOperation operation;
    private double amount;


    @Override
    public String toString() {
        return accountNumber + " data: " + date.toString() + " " + String.format("%-10s", operation.toString()) + " " + String.format("%8.2f", amount) + " zl";
    }

}
