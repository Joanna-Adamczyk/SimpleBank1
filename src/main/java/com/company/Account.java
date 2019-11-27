package com.company;

import javax.security.auth.login.AccountException;

public class Account implements IBankAccount{
    /**
     * Statyczna skladowa initialAccountNumber startuje od wartosci 10 000
     */
    static int initialAccountNumber = 10_000;
    public int getAccountNumber() {
        return number;
    }

    private int number;

    /**
     * Metoda getBalance pobiera stan konta (w PLN)
     * @return stan konta
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Metoda getOwner pobiera obiekt zawierajacy wszystkie dane o kliencie banku (wlascicielu konta bankowego)
     * @return
     */
    public Owner getOwner() {
        return owner;
    }
    private double balance;
    private Owner owner;

    /**
     * Konstruktor klasy Account
     * @param number numer konta
     * @param owner wlasciciel konta
     */
    private Account(int number, Owner owner) {
        this.number = number;
        this.owner = owner;
        this.balance = 0;
    }

    /**
     * Dwuparametrowy konstruktor klasy Account
     * @param owner
     */
    public Account(Owner owner) {
        this.number = getNextNumber();
        this.owner = owner;
        this.balance = 0;
    }

    /**
     * Konstruktor klasy Account
     * @param number numer konta
     * @param firstName imie klienta
     * @param lastName nazwisko klienta
     * @param PESEL numer PESEL klienta
     * @param address adres klienta
     */
    public Account(int number, String firstName, String lastName, String PESEL, Address address) {
        this.number = number;
        this.owner = new Owner(firstName, lastName, address, PESEL);
    }

    /**
     * Metoda add dodaje wplate w kwocie 'amount' do stanu konta
     * @param amount
     */
    public void add(double amount) {
        balance += amount;
    }

    /**
     * Motoda payOff wyjmuje z konta kwote wyplaty w wartosci 'amount'
     * @param amount
     * @return
     * @throws AccountException
     */
    public boolean payOff(double amount) throws AccountException {
        if (amount > balance)
            throw new AccountException("Kwota jest wieksza od posiadanych srodkow na koncie!");
        balance -= amount;
        return true;
    }

    private int getNextNumber() {
        int num = initialAccountNumber++;
        char[] tab = String.valueOf(num).toCharArray();
        int sum = 0;
        for(char c : tab)
            sum += c;
        sum = sum % 10;
        num = num * 10 + sum;
        return num;
    }

    @Override
    public String toString() {
        return number + " " + String.format("%8.2f", getBalance()) + " owner: " + owner.toString();
    }
}
