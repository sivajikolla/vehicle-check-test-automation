package com.ui.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.opencsv.bean.CsvBindByName;

@JsonPropertyOrder({"registration", "make", "model", "color", "year"})
public class VehicleDetailsDTO {

    @CsvBindByName( column = "registration",required=true)
    private String registration;

    @CsvBindByName( column = "make",required=true)
    private String make;

    @CsvBindByName( column = "model",required=true)
    private String model;

    @CsvBindByName( column = "color",required=true)
    private String color;

    @CsvBindByName( column = "year",required=true)
    private String year;

    public VehicleDetailsDTO() {
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    @Override
    public String toString() {
        return "VehicleDetailsDto{" +
                "registration=" + registration +
                ", make='" + make + '\'' +
                ", model=" + model +
                ", color=" + color +
                ", year=" + year +
                '}';
    }
}