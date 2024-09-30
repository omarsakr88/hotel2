package com.example.demo;

import com.sun.source.tree.BreakTree;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Reservation extends BaseObject {
    private Date startDate;
    private Date endDate;
    private Double price;
    private Guest guest;
    private Room room;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String print() {
            String s = "";
            s += "ID:";
            s += getId();
            s += "\n";
            s += "Start date:";
            s += startDate;
            s += "\n";
            s += "End date:";
            s += endDate;
            s += "\n";
            s += "Price:";
            s += price;
            s += "\n";
            s += "guest";
            s += "\n";
            s += guest.print();
            s += "\n";
            s += "room";
            s += "\n";
            s += room.print();
            s += "\n";
            return s;
        }
    }

