package com.pretkej.jee.servlets.customer;

import com.pretkej.jee.model.customer.CreateCustomerDto;
import com.pretkej.jee.model.customer.CustomerService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customers")
public class CustomerCRUD extends HttpServlet {
    @EJB
    CustomerService customerService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(customerService.getAllCustomers().toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String birthYear = req.getParameter("birthYear");

        if (name != null && surname != null && birthYear != null) {
            int bYasInt = Integer.parseInt(birthYear);
            CreateCustomerDto createCustomerDto = new CreateCustomerDto(name, surname, bYasInt);
            resp.getWriter().write(customerService.addCustomer(createCustomerDto).toString());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String birthYear = req.getParameter("birthYear");

        if (name != null && surname != null && birthYear != null) {
            int bYasInt = Integer.parseInt(birthYear);
            int idAsInt = Integer.parseInt(id);
            try {
                resp.getWriter().write(customerService.updateCustomer(idAsInt, name, surname, bYasInt).toString());
            } catch (Exception e) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            int idAsInt = Integer.parseInt(id);
            customerService.deleteCustomer(idAsInt);
        }
    }
}
