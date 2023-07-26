package uz.sarvar.hotelbooking.controller;

import uz.sarvar.hotelbooking.dao.ReservationDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "reservation", value = "/reservation")
public class ReservationController extends HttpServlet {
    private final ReservationDAO reservationDAO=ReservationDAO.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookingNumber = req.getParameter("bookingNumber");
        String roomNumber = req.getParameter("roomNumber");
        try {
            reservationDAO.reserved(bookingNumber,roomNumber);
            resp.sendRedirect("/admin");

        } catch (SQLException e) {
            resp.sendRedirect("/error");
        }
    }
}
