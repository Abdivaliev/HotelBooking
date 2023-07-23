package uz.sarvar.hotelbooking.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "booking", value = "/booking")
public class BookingController extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("firstName"));
        System.out.println(req.getParameter("surname"));
        System.out.println(req.getParameter("status"));
        System.out.println(req.getParameter("startDate"));
        System.out.println(req.getParameter("endDate"));
        System.out.println(req.getParameter("phoneNumber"));
        System.out.println(req.getParameter("email"));
        System.out.println(req.getParameter("numberOfBeds"));

    }

    public void destroy() {
    }
}