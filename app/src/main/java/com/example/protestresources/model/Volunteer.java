package com.example.protestresources.model;

public class Volunteer {

    private final String name;
    private final String phone;
    private final String location;

    private final String email;

    public Volunteer(String name, String phone, String location, String email) {
        this.name = name;
        this.phone = phone;
        this.location = location;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

}