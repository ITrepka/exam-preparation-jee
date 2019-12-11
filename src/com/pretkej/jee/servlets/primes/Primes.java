package com.pretkej.jee.servlets.primes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/primes")
public class Primes extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        int[] primes = new int[1001];
        primes[0] = -1;
        primes[1] = -1;
        for (int i = 2; i <= Math.sqrt(1000); i++) {
            if (primes[i] != -1) {
                for (int j = i * 2; j <= 1000; j += i) {
                    primes[j] = -1;
                }
            }
        }

        for (int i = 0; i < primes.length; i++) {
            if (primes[i] != -1) {
                resp.getWriter().write(i + " ");
            }
        }
    }
}
