package com.oracle.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class T1 {

    public static void main(String[] args) throws IOException {
        //读文件
        InputStream ins = null;
        ins = Resources.getResourceAsStream("mybatis-configer.xml");

//        try {
//            ins = Resources.getResourceAsStream("mybatis-configer.xml");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //创建连接工厂
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(ins);

        //打开连接
        SqlSession ss = sf.openSession(true);
        System.out.println("OVer");
    }

}
