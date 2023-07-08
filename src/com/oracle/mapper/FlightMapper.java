package com.oracle.mapper;

import com.oracle.model.Flight;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FlightMapper {
    List<Flight> search(@Param("startCity") String startCity,
                        @Param("endCity") String endCity,
                        @Param("flightDate") String flightDate);
}
