#### HTML、CSS基础

```html
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>标题</title>

</head>

<body>

    <h1>标题1</h1>
    <h2>标题2</h2>
    <h3>标题3</h3>
    <h4>标题4</h4>
    <h5>标题5</h5>
    <h6>标题6</h6>

    <u> 下划线</u>
    <b> 加粗</b>

    <p>段落1</p>
    <p>段落2</p>

    <div>块1</div>
    <div>块2</div>

    <span>文本1</span>
    <span>文本2</span>

    <!-- 换行 -->
    <br>

    <img src="source/folder.jpg" width="400px"><br>

    <audio controls>
        <source src="source/V在燃烧 - I Got Smoke (Feat.V在燃烧).mp3" type="audio/mpeg">
        您的浏览器不支持 audio 元素。
    </audio><br>


    <video width="800px" height="500px" controls>
        <source src="source/丁真新单曲《烟Distance》痛苦流说唱.mp4" type="video/mp4">
        您的浏览器不支持Video标签。
    </video><br>

    <iframe src="//player.bilibili.com/player.html?aid=946637605&bvid=BV1UW4y1N79w&cid=934177798&page=1" width="800px" height="500px" scrolling="no" border="0" frameborder="no" framespacing="0" allowfullscreen="true"> </iframe>
    
    <a href="https://www.baidu.com" target="_blank">baidu</a><br>

    <!-- 表单 -->
    <form action="https://www.baidu.com">
        <!-- value默认值 placeholder提示信息 -->
        账号:<input type="text" name="text" value="" placeholder="请输入账号"><br>
        密码:<input type="password" name="password" value="" placeholder=""><br>
        <!-- 日期:<input type="date" name="date" value="" placeholder=""><br> -->
        <!-- 颜色:<input type="color" name="color" value="" placeholder=""><br> -->
        <!-- 文件:<input type="file" name="file" value="" placeholder=""><br> -->

        <!-- 提交 form指定提交地址 input有name属性-->
        <input type="submit" value="提交"><br>
        <!-- <button type="submit">提交</button> -->
    </form>
</body>

</html>
```

#### 写登录页面

```html
<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>航空客户在线订票系统</title>
    <style>
        .main {
            /* text-align: center; */
            /*让div内部文字居中*/
            background-color: #ffffff79;
            border-radius: 20px;
            width: 300px;
            height: 350px;
            margin: auto;
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
        }
    </style>
</head>

<body>
    <div class="main">
        <div>
            航空客户在线订票系统
        </div>

        <img src="http://jwglxt.zua.edu.cn/eams/static/images/education-logo.png" height="100px">
        <form action="http://localhost:8081/air/login">
            <div>
                账号: <input type="text" name="username" placeholder="请输入账号"><br>
                密码: <input type="password" name="password" placeholder="请输入密码"><br>
            </div>
            <p>
                <input type="submit" value="提交"><br>
            </p>
        </form>
    </div>

</body>

</html>
```

#### 连接Servlet登录

`src/com/oracle/servlets/LoginServlet.java`

```java
package com.oracle.servlets;

import com.oracle.mapper.PassengerMapper;
import com.oracle.mapper.UserMapper;
import com.oracle.model.User;
import com.oracle.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 连接数据库
        SqlSession ss = MybatisUtil.createSqlSession();
        UserMapper mapper = ss.getMapper(UserMapper.class);
        User user = mapper.findByUsername(username);
        ss.close();

        // 流输出
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = resp.getWriter();

        // 响应结果
        if (user == null || !user.getPassword().equals(password)) {
//            pw.println("用户名或密码错误");
            // 页面跳转
            resp.sendRedirect("http://localhost:8081/web/mypage/login.html");
        } else {
//            pw.println("登陆成功");
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("http://localhost:8081/air/page/index.jsp");
        }
    }
}
```

#### JSP（Java Server Page）技术

`web/page/index.jsp`

登录成功显示，欢迎+用户名

```html
                    <div class="welcome clearfix"><span>欢迎您,</span><a href="javascript:;" class="user-name">${sessionScope.user.username}</a></div>
```

