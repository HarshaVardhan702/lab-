package com.klef.fsad.exam;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String status;

    private String location;
    private double amount;

    // Constructors
    public Booking() {}

    public Booking(String name, Date date, String status, String location, double amount) {
        this.name = name;
        this.date = date;
        this.status = status;
        this.location = location;
        this.amount = amount;
    }

    // Getters & Setters
    public int getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}