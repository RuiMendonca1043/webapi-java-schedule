package com.barbearia.real.backend.persistence.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Service {
    @Id
    private ObjectId id;
    private ServiceType type;
    private String title;
    private int time;
    private double price;
    private String description;

    public String getId() {
        return id.toHexString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getType() {
        return type.toString();
    }

    public void setType(String type) {
        if (type.equals("BARBA")) {
            this.type = ServiceType.BARBA;
        } else if (type.equals("CABELO")) {
            this.type=ServiceType.CABELO;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    enum ServiceType{
        CABELO,
        BARBA
    }
}

