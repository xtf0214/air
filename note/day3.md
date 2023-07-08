#### tomcat框架

1. 配置环境变量

`JAVA_HOME=C:\Program Files\Java\jdk1.8.0_361`

2. 启动服务器

`D:\Software\apache-tomcat-9.0.43\bin\startup.bat`

3. 打开浏览器，进入 `localhost:8080` （端口可能冲突，可以在 `\conf\server.xml` 修改）

（可选 ：设置中文https://www.cnblogs.com/subsea/p/13493537.html）

#### IDEA使用Tomcat框架

1. 升级项目为web项目

右键项目，Add Framework Support，Web Application

2. 设置包路径 `web/WEB-INF/lib` ，添加 `jstl` 和 `standard`
3. Edit Configurations，添加 Tomcat Server Local，设置路径为本地tomcat路径

#### 静态资源映射

#### 动态资源

#### Servlet

##### 导入包 `servlet-api`

##### 写Servlet程序

1. 创建类继承HttpServlet
2. 重写doget方法，写入自己的逻辑
3. 通过@WebServlet注解，设置访问路径

```java
package com.oracle.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/test1")
public class TestServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.println(new Date());

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = resp.getWriter();

        pw.println(new Date());
        pw.println("hello world");
        pw.println("你好");

        pw.close();
    }

}
```

   



