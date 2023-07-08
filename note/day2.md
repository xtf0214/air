#### 配置IDEA Java开发环境

#### 熟悉MySQL的一些命令，使用数据库软件连接MySQL数据库

```sql
SELECT
DELETE
INSERT
```

#### Mybatis框架，配置环境

导入包

`jars/mybatis-3.5.9.jar`

`jars/mysql-connector-java-8.0.28.jar`

配置文件

`src/mybatis-configer.xml`

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

<!--	<settings>-->
<!--	    <setting name="autoMappingBehavior" value="FULL" />-->
<!--        <setting name="mapUnderscoreToCamelCase" value="true"/>-->
<!--	</settings>-->
<!--  <typeAliases>-->
<!--    <package name="com.oracle.model"/>-->
<!--  </typeAliases>-->
  <environments default="development">
    <environment id="development">
      <transactionManager type="JDBC"/>
      <dataSource type="POOLED">
<!--        com.mysql.cj.jdbc.Driver-->
        <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://localhost:3306/air?characterEncoding=utf8"/>
        <property name="username" value="root"/>
        <property name="password" value="995983"/>
      </dataSource>
    </environment>
  </environments>

  <mappers>
    <package name="com.oracle.mapper"/>
  </mappers>
  
</configuration>
```

#### 使用Mybatis连接数据库，完成数据库增删改查操作

##### User实体类

`src/com/oracle/model/User.java`

```Java
package com.oracle.model;

public class User {
    private String username;
    private String password;
    private int banlance;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getBanlance() {
        return banlance;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBanlance(int banlance) {
        this.banlance = banlance;
    }
}
```

##### UserMapper接口

`src/com/oracle/mapper/UserMapper.java`

```java
package com.oracle.mapper;

import com.oracle.model.User;

import java.util.List;

public interface UserMapper {
    int addUser(User user);

    List<User> findAll();

    User findByUsername(String username);

}
```

##### 映射文件

`src/com/oracle/mapper/UserMapper.xml`

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.oracle.mapper.UserMapper">
    <insert id="addUser">
        insert into user
        values(#{username},#{password},#{banlance});
    </insert>

    <select id="findAll" resultType="com.oracle.model.User">
        select * from user
    </select>

    <select id="findByUsername" resultType="com.oracle.model.User">
        select * from user where username=#{username}
    </select>

</mapper>
```

##### MyBatis施法前摇

`src/com/oracle/util/MybatisUtil.java`

```java
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
```

##### 测试登录

```java
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
```

#### 作业

完成对乘客的增删操作，根据用户名查找其名下的乘客信息。

`src/com/oracle/model/Passenger.java`

```java
package com.oracle.model;

public class Passenger {
    private int pid, cardnum;
    private String pname, username, phone;
    public Passenger() {

    }
    public Passenger(int pid, String pname, int cardnum, String phone,  String username) {
        this.pid = pid;
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
```

`src/com/oracle/mapper/PassengerMapper.java`

```java
package com.oracle.mapper;

import com.oracle.model.Passenger;

import java.util.List;

public interface PassengerMapper {
    int addPassenger(Passenger passenger);

    int delPassengerByPid(int pid);

    List<Passenger> findPassengerByUsername(String username);

}
```

`src/com/oracle/mapper/PassengerMapper.xml`

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.oracle.mapper.PassengerMapper">
<!--  null自动生成pid  -->
    <insert id="addPassenger" useGeneratedKeys="true">
        insert into passenger
        values (null, #{pname}, #{cardnum}, #{phone}, #{username});
    </insert>

    <delete id="delPassengerByPid">
        delete
        from passenger
        where pid = #{pid}
    </delete>

    <select id="findPassengerByUsername" resultType="com.oracle.model.Passenger">
        select *
        from passenger
        where username = #{username}
    </select>

</mapper>
```

测试

`src/com/oracle/test/T3.java`

```java
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

        Passenger passenger1 = new Passenger(17,"Bob",123456,"1234567890","Bob");
        Passenger passenger2 = new Passenger(19,"Tom",123456,"1234567890","Bob");
        Passenger passenger3 = new Passenger(20, "John", 123456, "1234567890", "Bob");
        mapper.addPassenger(passenger1);
        mapper.addPassenger(passenger2);
        mapper.addPassenger(passenger3);

        int a = mapper.delPassengerByPid(26);
        System.out.println("delete passenger number: " + a);

        List<Passenger> ls = mapper.findPassengerByUsername("Bob");
        System.out.println(ls);
    }
}
```

