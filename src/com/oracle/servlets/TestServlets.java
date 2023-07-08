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
