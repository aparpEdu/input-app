package com.example.a4uprmb.people;

public class People {
    private final String name;
    private final String phone;
    private final String address;
    private final String city;

    public People(String name, String phone, String address, String city) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }
}
