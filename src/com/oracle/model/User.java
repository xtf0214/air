package com.oracle.model;

public class User {
    private String username;
    private String password;
    private int banlance;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getBanlance() {
        return banlance;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBanlance(int banlance) {
        this.banlance = banlance;
    }
}
