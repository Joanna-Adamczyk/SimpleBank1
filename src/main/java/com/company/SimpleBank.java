package com.company;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Klasa SimpleBank jest kluczowa w tym projekcie i jest singletonem (lazy loading)
 */
public class SimpleBank {

    /**
     * mapaKont zawiera wszystkie konta w banku SimpleBank
     */
    private HashMap<Integer, Account> mapaKont = new HashMap<Integer, Account>();
    private List<Transaction> transakcje = new ArrayList<>();
    private static SimpleBank instance = null;


    private static SimpleBank INSTANCE;

    /**
     * Prywatny konstruktor (uzywany wylacznie przez metode 'getInstance')
     */
    
    private SimpleBank() {
        init();
    }

    public static SimpleBank getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SimpleBank();
        }
        return INSTANCE;
    }

    /**
     * Metoda init tworzy konta bankowe i inicjuje liste transakcji 'transakcje'
     */
    private void init() {
        transakcje = new ArrayList<>();
        Owner[] owners = new Owner[] {
                new Owner("Jan", "Kowalski",  new Address("Poznan",  "60-265", "Strusia 1"), "1274557890"),
                new Owner("Jan",   "Kowal",   new Address("Katowice","20-364", "Kocia 19"),  "3274537890"),
                new Owner("Anna",  "Nowak",   new Address("Mosina",  "62-063", "Mokra 12"),  "3264527890"),
                new Owner("Leon",  "Pasterz", new Address("Leszno",  "64-161", "Prosta 9"),  "4264517890"),
                new Owner("Zenon", "Kotecki", new Address("Rawicz",  "63-507", "Polska 11"), "5254507890"),
        };
        for(Owner owner : owners) {
            Account konto = new Account(owner);
            mapaKont.put(konto.getAccountNumber(), konto);
        }
    }

    /**
     * Metoda add dodaje okreslona kwote (amount) do stanu konta bankowego o numerze 'number'
     * @param number numer konta bankowego
     * @param amount kwota wplaty
     * @return true = transakcja zostala przeprowadzone, false = transakcja posiadala bledy
     * @throws AccountException
     */
    public boolean add(int number, double amount) throws AccountException {
        if (amount < 0)
            throw new AccountException("Kwota nie moze byc ujemna!");
        if (!checkAccountNumber(number))
            throw new AccountException("Nie ma takiego konta!");
        Account konto = mapaKont.get(number);
        konto.add(amount);
        transakcje.add(new Transaction(number, LocalDateTime.now(), BankOperation.Add, amount));
        return true;
    }

    /**
     Metoda payOff przeprowadza wyplate kwoty 'amount' z konta o numerze 'number'
     * @param number numer konta bankowego
     * @param amount kwota wyplaty
     * @return true = transakcja zostala przeprowadzone, false = transakcja posiadala bledy
     * @throws AccountException
     */

    public boolean payOff(int number, double amount) throws AccountException, javax.security.auth.login.AccountException {
        if (amount < 0)
            throw new AccountException("Kwota nie moze byc ujemna!");
        if (!checkAccountNumber(number))
            throw new AccountException("Nie ma takiego konta!");
        Account konto = mapaKont.get(number);
        konto.payOff(amount);
        transakcje.add(new Transaction(number, LocalDateTime.now(), BankOperation.PayOff, amount));
        return true;
    }

    /**
     * Procedura sprawdza czy konto o podanym 'number' istnieje
     * @param number - numer konta bankowego
     * @return true = konto jest, false = konta nie ma
     */
    private boolean checkAccountNumber(int number) {
        if (mapaKont.containsKey(number))
            return true;
        else
            return false;
    }

    /**
     * Metoda addAcount dodaje konto w bankku dla klienta 'owner'
     * @param owner klient banku (wlasciciel konta)
     * @return true = konto zostalo dodane
     */
    public boolean addAccount(Owner owner) {
        Account acc = new Account(owner);
        return true;
    }

    /**
     * Metoda showAccounts prezentuje stany wszystkich kont posortowane wg czasu transakcji
     */
    public void showAccounts() {
        System.out.println("=== ACCOUNTS: ===");
        List<Account> konta = mapaKont.entrySet()
                .stream()
                .map(p-> p.getValue())
                .collect(Collectors.toList());
        for(Account konto : konta)
            System.out.println(konto.toString());
        System.out.println("=== END OF ACCOUNTS: ===");
    }

    /**
     * Metoda showTransactions prezentuje wszystkie przeprowadzone transakcje
     */
    public void showTransactions() {
        System.out.println("=== TRANSACTIONS: ===");
        List<Transaction> posortowane = transakcje
                .stream()
                .sorted((p1,p2) -> p1.getDate().compareTo(p2.getDate()))
                .collect(Collectors.toList());
        for(Transaction tr : posortowane)
            System.out.println(tr.toString());
        System.out.println("=== END OF TRANSACTIONS: ===");
    }
}


