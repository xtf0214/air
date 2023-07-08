#### 引入 Mybatis 依赖架包

复制以下代码到 `porm.xml` 文件里

```xml
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.10</version>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.22</version>
</dependency>
```

#### 添加核心配置文件

添加 `src/main/resources/mybatis3.xml`

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">

<!-- 通过这个配置文件完成mybatis与数据库的连接 -->
<configuration>
    <!-- 配置mybatis的log实现为LOG4J -->
    <settings>
        <setting name="logImpl" value="LOG4J"/>
    </settings>

    <environments default="test">
        <environment id="test">
            <!--配置事务管理，采用JDBC的事务管理  -->
            <transactionManager type="JDBC"></transactionManager>
            <!-- POOLED:mybatis自带的数据源，JNDI:基于tomcat的数据源 -->
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url"
                          value="jdbc:mysql://localhost:3306/air?characterEncoding=utf8&amp;useSSL=false&amp;serverTimezone=UTC&amp;rewriteBatchedStatements=true"/>
                <property name="username" value="root"/>
                <property name="password" value="995983"/>
            </dataSource>
        </environment>
    </environments>
<mappers>
    <mapper resource="mappers/UserMapper.xml"/>
</mappers>

</configuration>
```

修改**数据库地址**、**数据库名**、**用户**和**密码**

```xml
				<property name="url"
                          value="jdbc:mysql://localhost:3306/air?characterEncoding=utf8&amp;useSSL=false&amp;serverTimezone=UTC&amp;rewriteBatchedStatements=true"/>
                <property name="username" value="root"/>
                <property name="password" value="995983"/>
```

#### 添加工具类

`src/main/java/com/oracle/y6/mybatis/utils/MyBatisUtil.java`

```java
package com.oracle.y6.mybatis.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MyBatisUtil {
    private static SqlSessionFactory factory;

    static{//在静态代码块下，factory只会被创建一次

        try {
            InputStream is = Resources.getResourceAsStream("mybatis3.xml");
            factory = new SqlSessionFactoryBuilder().build(is,"test");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static SqlSession createSqlSession(){
        return factory.openSession(true);//true 为自动提交事务
    }

    public static void closeSqlSession(SqlSession sqlSession){
        if(null != sqlSession)
            sqlSession.close();
    }
}
```

#### 添加日志跟踪

`porm.xml`

```xml
<dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>1.2.12</version>
</dependency>
```

添加日志配置 `src/main/resources/log4j.properties`

```properties
log4j.rootLogger=info,CONSOLE
#log4j.rootLogger=ERROR,ROLLING_FILE
log4j.logger.com.oracle.y6.mybatis.mappers=TRACE
log4j.logger.com.ibatis=info
log4j.logger.com.ibatis.common.jdbc.SimpleDataSource=info
log4j.logger.com.ibatis.common.jdbc.ScriptRunner=info
log4j.logger.com.ibatis.sqlmap.engine.impl.SqlMapClientDelegate=info
log4j.logger.java.sql.Connection=info
log4j.logger.java.sql.Statement=trace
log4j.logger.java.sql.PreparedStatement=debug
log4j.logger.java.sql.ResultSet=debug
#log4j.logger.org.tuckey.web.filters.urlrewrite.UrlRewriteFilter=debug

######################################################################################
# Console Appender  \u65e5\u5fd7\u5728\u63a7\u5236\u8f93\u51fa\u914d\u7f6e
######################################################################################
log4j.appender.CONSOLE=org.apache.log4j.ConsoleAppender
log4j.appender.Threshold=error
log4j.appender.CONSOLE.Target=System.out
log4j.appender.CONSOLE.layout=org.apache.log4j.PatternLayout
log4j.appender.CONSOLE.layout.ConversionPattern= [%p] %d %c - %m%n




log4j.logger.com.opensymphony.xwork2=error  

```

#### 测试环境junit

添加类`src/test/java/TestMybatis.java`

```java
import com.oracle.y6.mybatis.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

public class TestMybatis {
    @Test
    public void test1()
    {
        SqlSession ss= MyBatisUtil.createSqlSession();
        System.out.println(ss);
    }
    @Test
    public void test2()
    {
        System.out.println("测试");
    }
}
```

#### 实现第一个查询

添加实体类 `src/main/java/com/oracle/y6/mybatis/entity/User.java`

```java
package com.oracle.y6.mybatis.entity;

public class User {
    private String username;
    private String password;
    private Double banlance;

    public String getUsername() {
        return username;
    }
    public Double getBanlance() {
        return banlance;
    }
    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBanlance(Double banlance) {
        this.banlance = banlance;
    }
}
```

添加接口 `src/main/java/com/oracle/y6/mybatis/mappers/UserMapper.java`

```java
package com.oracle.y6.mybatis.mappers;

import com.oracle.y6.mybatis.entity.User;
import java.util.List;

public interface UserMapper {
    public List<User> findUser();
}
```

添加映射文件

`src/main/resources/mappers/UserMapper.xml`

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.oracle.y6.mybatis.mappers.UserMapper">
    <select id="findUser" resultType="com.oracle.y6.mybatis.entity.User">
        select * from user
    </select>
</mapper>
```

注册映射文件添加到 `src/main/resources/mybatis3.xml`

```xml
<mappers>
    <mapper resource="mappers/UserMapper.xml"/>
</mappers>
```

#### 测试UserMapper

```java
import com.oracle.y6.mybatis.entity.User;
import com.oracle.y6.mybatis.mappers.UserMapper;
import com.oracle.y6.mybatis.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

public class UserMapperTest {
    @Test
    public void testFinderUser() {
        SqlSession ss = MyBatisUtil.createSqlSession();
        UserMapper mapper = ss.getMapper(UserMapper.class);
        mapper.findUser();
    }
}
```

