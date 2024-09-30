package com.example.demo;

import java.util.Scanner;

public class Guest extends BaseObject {
    private String name;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String print() {
        String s = "";
        s += "ID:";
        s += getId();
        s += "\n";
        s += "Name:";
        s += name;
        s += "\n";
        s += "Address:";
        s += address;
        s += "\n";
        return s;
    }
}
