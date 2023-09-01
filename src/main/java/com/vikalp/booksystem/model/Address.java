package com.vikalp.booksystem.model;

import com.mongodb.lang.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Address {
    @NotNull
    @NotBlank
    private String houseNum;
    @NotNull
    @NotBlank
    private String city;
    @NotNull
    @NotBlank
    private String state;

    public Address(String houseNum, String city, String state){
        this.houseNum = houseNum;
        this.city = city;
        this.state = state;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
