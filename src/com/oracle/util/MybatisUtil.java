package com.oracle.util;

import jdk.internal.util.xml.impl.Input;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    private static SqlSessionFactory factory;

    static {
        try {
            InputStream ins = Resources.getResourceAsStream("mybatis-configer.xml");
            factory = new SqlSessionFactoryBuilder().build(ins);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  static SqlSession createSqlSession() {
        return factory.openSession(true);
    }
    public  static void closeSqlSession(SqlSession sqlSession) {
        if (sqlSession != null)
            sqlSession.close();
    }
}
