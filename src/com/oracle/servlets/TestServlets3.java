package com.oracle.servlets;

import com.oracle.mapper.PassengerMapper;
import com.oracle.model.Passenger;
import com.oracle.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test3")
public class TestServlets3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        int pid = Integer.parseInt(req.getParameter("pid"));

        SqlSession ss = MybatisUtil.createSqlSession();
        PassengerMapper mapper = ss.getMapper(PassengerMapper.class);

        int a = mapper.delPassengerByPid(pid);

        ss.close();

        PrintWriter writer = resp.getWriter();
        writer.println("delete passenger number: "+a);
        writer.close();
    }
}
