package com.example.workersfound.model;

public class Address {

    private String city;

    private String district;
    private String streetName;
    private String houseNumber;

    public Address(String city, String district, String streetName, String houseNumber) {
        this.city = city;
        this.district = district;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
