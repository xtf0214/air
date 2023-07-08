package com.oracle.servlets;

import com.oracle.mapper.PassengerMapper;
import com.oracle.model.Passenger;
import com.oracle.model.User;
import com.oracle.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/plist")
public class PassengerListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取当前的用户名
        User user = (User) req.getSession().getAttribute("user");
        String username = user.getUsername();

        // 连接数据库
        SqlSession ss = MybatisUtil.createSqlSession();
        PassengerMapper mapper = ss.getMapper(PassengerMapper.class);
        List<Passenger> plist = mapper.findPassengerByUsername(username);

        // Servlet 转发 JSP
        req.setAttribute("plist",plist);
        req.getRequestDispatcher("/page/static/user/changlvke.jsp").forward(req, resp);
    }
}