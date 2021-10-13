package com.example.busapplication;

import java.sql.Blob;

public class Bus {
    int id;
    String bus_name;
    String source;
    String destination;
    String date;
    int amount;
    //byte[] image;

    public Bus(int id, String bus_name, String source, String destination, int amount, String date) {
        this.id = id;
        this.bus_name = bus_name;
        this.source = source;
        this.destination = destination;
        this.amount = amount;
        this.date = date;
        //this.image=image;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id=id;
    }

    public String getName() {
        return bus_name;
    }
    public void setName(String bus_name) {
        this.bus_name=bus_name;
    }

    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source=source;
    }

    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination=destination;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date=date;
    }

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount=amount;
    }

   /* public byte[] getImage() {
        return image;
    }
    public void setImage(byte[] image) {
        this.image=image;
    }
    */
}
