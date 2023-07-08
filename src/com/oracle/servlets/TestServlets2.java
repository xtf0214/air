package com.oracle.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test2")
public class TestServlets2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        String end = req.getParameter("end");
        int n = Integer.parseInt(end);
        PrintWriter printWriter = resp.getWriter();
        for (int i = 0; i < n; i++) {
            printWriter.println(i);
        }
        printWriter.close();
    }
}
