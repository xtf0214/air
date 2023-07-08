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
import java.util.Scanner;

public class LoginTest {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.next();
        System.out.println("请输入密码：");
        String password = scanner.next();

        SqlSession ss = MybatisUtil.createSqlSession();
        UserMapper mapper = ss.getMapper(UserMapper.class);

        User user = mapper.findByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            System.out.println("用户名或密码错误！");
        } else {
            System.out.println("登陆成功！");
        }
    }

}
