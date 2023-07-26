package uz.sarvar.hotelbooking.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "reservation", value = "/reservation")
public class ReservationController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookingNumber = req.getParameter("bookingNumber");
        String roomNumber = req.getParameter("roomNumber");
        System.out.println(bookingNumber+"  "+roomNumber);
    }
}
