package com.example.admin.w3test;

import java.io.Serializable;

/**
 * Created by admin on 9/15/2017.
 */

public class Car implements Serializable{
    String model, type, year;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Car(String model, String type, String year) {

        this.model = model;
        this.type = type;
        this.year = year;
    }
}
