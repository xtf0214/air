package com.oracle.servlets;

import com.oracle.mapper.PassengerMapper;
import com.oracle.model.Passenger;
import com.oracle.model.User;
import com.oracle.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/padd")
public class PassengerAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pname = req.getParameter("pname");
        int cardnum = Integer.parseInt(req.getParameter("cardnum"));
        String phone = req.getParameter("phone");
        User user = (User) req.getSession().getAttribute("user");
        String username = user.getUsername();

        Passenger p = new Passenger(pname, cardnum, phone, username);

        SqlSession ss = MybatisUtil.createSqlSession();
        PassengerMapper mapper = ss.getMapper(PassengerMapper.class);
        mapper.addPassenger(p);

        resp.sendRedirect("/air/plist");
    }
}
