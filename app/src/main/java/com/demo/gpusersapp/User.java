package com.demo.gpusersapp;

public class User {

    public User(int id, String email, String name, String last_name, String avatar)
    {
        this.id = id;
        this.email = email;
        this.name = name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    public String toString()
    {

        return this.name + " " + this.last_name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    private int id;
    private String email, name, last_name, avatar;
}
