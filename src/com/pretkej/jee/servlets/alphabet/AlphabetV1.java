package com.pretkej.jee.servlets.alphabet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/alphabetV1")
public class AlphabetV1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        for (char letter = 'a'; letter <= 'z' ; letter++) {
            resp.getWriter().write(letter + " ");
        }
    }
}
