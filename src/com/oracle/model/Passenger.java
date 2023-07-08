package com.oracle.model;

public class Passenger {
    private int pid, cardnum;
    private String pname, username, phone;
    public Passenger() {

    }
    public Passenger(String pname, int cardnum, String phone,  String username) {
        this.cardnum = cardnum;
        this.phone = phone;
        this.pname = pname;
        this.username = username;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "pid=" + pid +
                ", cardnum=" + cardnum +
                ", pname='" + pname + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public int getPid() {
        return pid;
    }

    public int getCardnum() {
        return cardnum;
    }

    public String getPhone() {
        return phone;
    }

    public String getPname() {
        return pname;
    }

    public String getUsername() {
        return username;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setCardnum(int cardnum) {
        this.cardnum = cardnum;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
