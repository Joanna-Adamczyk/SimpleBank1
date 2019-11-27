package com.company;

public class Owner {

    private String firstName;
    private String lastName;
    private Address address;
    private String PESEL;


    /**
     * Konstruktor klasy Owner
     * @param firstName imie klienta
     * @param lastName nazwisko klienta
     * @param address adres klienta
     * @param pesel nr PESEL klienta
     */
    public Owner(String firstName, String lastName, Address address, String pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.PESEL = pesel;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public String getPESEL() {
        return PESEL;
    }

    //'%' means that what follows is an argument that will be formatted
    // '-' results in left alignment
    // '18' fills the string up to a length of 18 characters + 's' = string
    @Override
    public String toString() {
        return String.format("%-18s", firstName + "." + lastName) + " miasto:" + address.getCity();
    }
}
