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
            resp.sendRedirect("http://localhost:8081/web/mypage/login.html");
        } else {
//            pw.println("登陆成功");
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("http://localhost:8081/air/page/index.jsp");
        }
    }
}
