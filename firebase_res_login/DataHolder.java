package com.example.firebase_res_login;

public class DataHolder {
    private String name,phone,city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public DataHolder(String name, String phone, String city) {
        this.name = name;
        this.phone = phone;
        this.city=city;
    }
}
