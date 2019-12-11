package com.pretkej.jee.servlets.router;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/router2")
public class RouterV2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String site = req.getHeader("site");

        if (site != null) {
            if ("main".equals(site)) {
                resp.sendRedirect(resp.encodeRedirectURL("main.html"));
            } else if ("contact".equals(site)) {
                resp.sendRedirect(resp.encodeRedirectURL("contact.html"));
            } else if ("about".equals(site)) {
                resp.sendRedirect(resp.encodeRedirectURL("about.html"));
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        }
    }
}
