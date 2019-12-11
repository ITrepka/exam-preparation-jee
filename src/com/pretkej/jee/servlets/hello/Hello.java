package com.pretkej.jee.servlets.hello;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class Hello extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        resp.setContentType("text/html");
        resp.getWriter().write("Hello ");
        if (name != null) {
            resp.getWriter().write(name + " ");
        }
        if (surname != null) {
            resp.getWriter().write(surname);
        }
    }
}
