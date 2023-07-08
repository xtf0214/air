package com.oracle.test;

import com.oracle.mapper.PassengerMapper;
import com.oracle.model.Passenger;
import com.oracle.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class T3 {
    public static void main(String[] args) {
        SqlSession ss = MybatisUtil.createSqlSession();
        PassengerMapper mapper = ss.getMapper(PassengerMapper.class);

        Passenger passenger1 = new Passenger("Bob",123456,"1234567890","Bob");
        Passenger passenger2 = new Passenger("Tom",123456,"1234567890","Bob");
        Passenger passenger3 = new Passenger("John", 123456, "1234567890", "Bob");
        mapper.addPassenger(passenger1);
        mapper.addPassenger(passenger2);
        mapper.addPassenger(passenger3);

        int a = mapper.delPassengerByPid(26);
        System.out.println("delete passenger number: " + a);

        List<Passenger> ls = mapper.findPassengerByUsername("Bob");
        System.out.println(ls);
    }
}
