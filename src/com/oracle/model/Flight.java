package com.oracle.model;

public class Flight {
    private int fid;
    private String flightNum;
    private String flightDate;
    private String startCity;
    private String endCity;
    private String startTime;
    private String endTime;
    private int ticketPrice;
    private int ticketLeft;

    public Flight(String flightNum, String flightDate, String startCity, String endCity, String startTime, String endTime, int ticketPrice, int ticketLeft) {
        this.flightNum = flightNum;
        this.flightDate = flightDate;
        this.startCity = startCity;
        this.endCity = endCity;
        this.startTime = startTime;
        this.endTime = endTime;
        this.ticketPrice = ticketPrice;
        this.ticketLeft = ticketLeft;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getEndCity() {
        return endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getTicketLeft() {
        return ticketLeft;
    }

    public void setTicketLeft(int ticketLeft) {
        this.ticketLeft = ticketLeft;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "fid=" + fid +
                ", flightNum='" + flightNum + '\'' +
                ", flightDate='" + flightDate + '\'' +
                ", startCity='" + startCity + '\'' +
                ", endCity='" + endCity + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", ticketLeft=" + ticketLeft +
                '}';
    }
}
