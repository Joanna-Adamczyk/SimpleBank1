package com.company;

import javax.security.auth.login.AccountException;

public interface IBankAccount {
    /**
     * Interfejs IBankAccount zapewnia wszystkie ważne operacja wykonywane na koncie bankowym
     */

    public void add(double amount);
    public boolean payOff(double amount) throws AccountException;
    public double getBalance();
    public int getAccountNumber();
}
