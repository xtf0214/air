package com.oracle.mapper;

import com.oracle.model.Passenger;

import java.util.List;

public interface PassengerMapper {
    int addPassenger(Passenger passenger);

    int delPassengerByPid(int pid);

    List<Passenger> findPassengerByUsername(String username);

}
