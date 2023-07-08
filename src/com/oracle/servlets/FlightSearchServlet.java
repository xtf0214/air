package com.oracle.servlets;

import com.oracle.mapper.FlightMapper;
import com.oracle.model.Flight;
import com.oracle.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/fsearch")
public class FlightSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String startCity = req.getParameter("startCity");
        String endCity = req.getParameter("endCity");
        String flightDate = req.getParameter("flightDate");

        SqlSession sqlSession = MybatisUtil.createSqlSession();
        FlightMapper mapper = sqlSession.getMapper(FlightMapper.class);

        List<Flight> fs = mapper.search(startCity, endCity, flightDate);
        req.setAttribute("fs", fs);
        req.getRequestDispatcher("/page/static/ticket/order_step1.jsp").forward(req, resp);
    }
}
