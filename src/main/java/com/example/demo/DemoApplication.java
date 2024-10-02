package com.example.demo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

@SpringBootApplication
@RestController
public class DemoApplication {
    static ArrayList<Room> roomList = new ArrayList<>();
    static ArrayList<Guest> guestList = new ArrayList<>();
    static ArrayList<Reservation> reservationList = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/newRoom")
    public String newRoom(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "number") Integer number,
            @RequestParam(value = "price") Double price
    ) {
        Room room = new Room();
        room.assignNewId();
        room.setName(name);
        room.setNumber(number);
        room.setPrice(price);
        roomList.add(room);
        return "success";
    }

    @GetMapping("/modifyRoom")
    public String modifyRoom(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "number") Integer number,
            @RequestParam(value = "price") Double price,
            @RequestParam(value = "ID") Integer id
    ) {
        Room room = getRoom(id);
        if (room == null) {
            return "Room not found";
        }
        room.setName(name);
        room.setNumber(number);
        room.setPrice(price);
        return "success";
    }

    @GetMapping("/removeRoom")
    public String removeRoom(
            @RequestParam(value = "ID") Integer id
    ) {

        Room room = getRoom(id);
        if (room == null) {
            return "room not found";
        }
        roomList.remove(room);
        return "success";
    }


    @GetMapping("/newGuest")
    public String newGuest(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "address") String address
    )   {
        Guest guest = new Guest();
        guest.assignNewId();
        guest.setName(name);
        guest.setAddress(address);
        guestList.add(guest);
        return "success";
    }

    @GetMapping("/renameGuest")
    public String renameGuest(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "address") String address,
            @RequestParam(value = "ID") Integer id
    ) {

        Guest guest = getGuest(id);
        if (guest == null) {
            return "guest not found";
        }
        guest.setName(name);
        guest.setAddress(address);
        return "success";
    }

    @GetMapping("/removeGuest")
    public String removeGuest(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "address") String address,
            @RequestParam(value = "ID") Integer id
    ) {

        Guest guest = getGuest(id);
        if (guest == null) {
            return "guest not found";
        }
        guestList.remove(guest);
        return "success";
    }


    @GetMapping("/newReservation")
    public String newReservation(
            @RequestParam(value = "startdate") Date startDate,
            @RequestParam(value = "enddate") Date endDate,
            @RequestParam(value = "price") Double price,
            @RequestParam(value = "guestID") Integer guestId,
            @RequestParam(value = "roomID") Integer roomId
    ) {
        Reservation reservation = new Reservation();
        reservation.assignNewId();
        Guest guest = getGuest(guestId);
        if (guest == null) {
            return "guest not found";
        }

        Room room = getRoom(roomId);
        if (room == null) {
            return "room not found";
        }
        reservation.setStartDate(startDate);
        reservation.setEndDate(endDate);
        reservation.setPrice(price);
        reservation.setRoom(room);
        reservation.setGuest(guest);
        reservationList.add(reservation);
        return "success";
    }

    @GetMapping("/modifyReservation")
    public String modifyReservation(
            @RequestParam(value = "start date") @DateTimeFormat(pattern = "dd/MM/yyyy") Date startDate,
            @RequestParam(value = "end date") @DateTimeFormat(pattern = "dd/MM/yyyy") Date endDate,
            @RequestParam(value = "price") Double price,
            @RequestParam(value = "guestID") Integer guestId,
            @RequestParam(value = "roomID") Integer roomId,
            @RequestParam(value = "ID") Integer id

    ) {

        Reservation reservation = getReservation(id);
        if (reservation == null) {
            return "reservation not found";
        }
        reservation.setStartDate(startDate);
        reservation.setEndDate(endDate);
        reservation.setPrice(price);
        return "success";
    }

    @GetMapping("/removeReservation")
    public String removeReservation(
            @RequestParam(value = "start date") Date startDate,
            @RequestParam(value = "end date") Date endDate,
            @RequestParam(value = "price") Double price,
            @RequestParam(value = "guestID") Integer guestId,
            @RequestParam(value = "roomID") Integer roomId,
            @RequestParam(value = "ID") Integer id
    ) {

        Reservation reservation = getReservation(id);
        if (reservation == null) {
            return "reservation not found";
        }
        reservationList.remove(reservation);
        return "success";
    }


    public Room getRoom(Integer id) {

        for (int i = 0; i < roomList.size(); i++) {
            Room room = roomList.get(i);
            if (room.getId().equals(id)) {
                return room;
            }
        }
        return null;
    }

    public Guest getGuest(Integer id) {
        for (int i = 0; i < guestList.size(); i++) {
            Guest guest = guestList.get(i);
            if (guest.getId().equals(id)) {
                return guest;
            }
        }
        return null;
    }

    public Reservation getReservation(Integer id) {
        for (int i = 0; i < reservationList.size(); i++) {
            Reservation reservation = reservationList.get(i);
            if (reservation.getId().equals(id)) {
                return reservation;
            }
        }
        return null;
    }

    @GetMapping("/print")
    public String print() {
        printRooms();
        printGuests();
        printReservations();
        return print();
    }

    @GetMapping("/printRooms")
    public String printRooms() {
        String s = "";
        s += "Rooms:";
        s += "\n";
        s += "\n";
        for (int i = 0; i < roomList.size(); i++) {
            Room room = roomList.get(i);
            s += room.print();
            s += "\n";
        }
        return s;
    }

    @GetMapping("/printGuests")
    public String printGuests() {
        String s = "";
        s += "Guests:";
        s += "\n";
        s += "\n";
        for (int i = 0; i < guestList.size(); i++) {
            Guest guest = guestList.get(i);
            s += guest.print();
            s += "\n";
        }
        return s;
    }

    @GetMapping("/printReservations")
    public String printReservations() {
        String s = "";
        s += "Reservations:";
        s += "\n";
        s += "\n";
        for (int i = 0; i < reservationList.size(); i++) {
            Reservation reservation = reservationList.get(i);
            s += reservation.print();
            s += "\n";
        }
        return s;
    }


}
