package com.company;

public class Address {
    private String code;
    private String city;
    private String street;

    /**
     * KOnstruktor klasy Address
     * @param code
     * @param city
     * @param street
     */
    public Address(String code, String city, String street) {
        this.code = code;
        this.city = city;
        this.street = street;
    }

    public String getCode() {
        return code;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

}
