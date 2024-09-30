package com.example.demo;

import java.util.Scanner;

public class Room extends BaseObject {
    private String name;
    private Integer number;
    private Double price;

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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
        s += "Number:";
        s += number;
        s += "\n";
        s += "Price:";
        s += price;
        s += "\n";
        return s;
    }


}
