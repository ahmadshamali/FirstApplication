package com.example.firstapplication.dataaccess;

public class Car {
    private int id;
    private String name;
    private String brand;
    private double price;
    private int seats;
    private String description;

    public Car(int id, String name, String brand, double price, int seats, String description) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.seats = seats;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name + " - " + brand + " - $" + price + " - Seats: " + seats;
    }
}
