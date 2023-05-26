package com.edu.uniminuto.eds.model;

public class User {

    private Integer userId;
    private String firstName;
    private String surName;
    private String position;

    public User() {

    }

    public User(String firstName, String surName, String position) {
        this.firstName = firstName;
        this.surName = surName;
        this.position = position;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
