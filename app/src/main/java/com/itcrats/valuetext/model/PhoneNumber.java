package com.itcrats.valuetext.model;

/**
 * Created by JANI SHAIK on 17/12/2019
 */

public class PhoneNumber {

    private String id;
    private String number;


    public PhoneNumber(String id, String number) {
        this.id = id;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
