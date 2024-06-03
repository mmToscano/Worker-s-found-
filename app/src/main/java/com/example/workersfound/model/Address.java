package com.example.workersfound.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Address implements Serializable {

    private Integer addressId;
    private String city;
    private String district;
    private String streetName;
    private String houseNumber;

    public Address(Integer addressId, String city, String district, String streetName, String houseNumber) {
        this.addressId = addressId;
        this.city = city;
        this.district = district;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    public static Address fromJson(JSONObject jsonObject){
        try{
            Integer addressId = jsonObject.getInt("address_id");
            String city = jsonObject.getString("city");
            String district = jsonObject.getString("district");
            String streetName = jsonObject.getString("street_name");
            String houseNumber = jsonObject.getString("house_number");
            return new Address(addressId, city, district, streetName, houseNumber);
        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", streetName='" + streetName + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                '}';
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
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
