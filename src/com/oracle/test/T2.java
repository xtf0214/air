package com.oracle.test;

import com.oracle.mapper.UserMapper;
import com.oracle.model.User;
import com.oracle.util.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {

        SqlSession ss = MybatisUtil.createSqlSession();

        UserMapper mapper = ss.getMapper(UserMapper.class);

//        增加用户
//        User user = new User();
//        user.setUsername("tanphoon");
//        user.setPassword("123456");
//        user.setBanlance(100);
//
//        int a = mapper.addUser(user);
//        System.out.println("add at line "+a);
        Scanner scanner = new Scanner(System.in);


        List<User> all = mapper.findAll();
        System.out.println(all.size());
    }
}
