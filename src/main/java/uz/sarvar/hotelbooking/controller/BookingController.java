package uz.sarvar.hotelbooking.controller;

import lombok.SneakyThrows;
import uz.sarvar.hotelbooking.dao.BookingDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet(name = "booking", value = "/booking")
public class BookingController extends HttpServlet {
    private String message;
    private BookingDAO bookingDAO = BookingDAO.getInstance();

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String surname = req.getParameter("surname");
        String statusRoom = req.getParameter("status");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        String phoneNumber = req.getParameter("phoneNumber");
        String email = req.getParameter("email");
        String numberOfBeds = req.getParameter("numberOfBeds");
        try {
            boolean saved = bookingDAO.save(statusRoom, numberOfBeds, startDate, endDate, firstName, surname, phoneNumber, email);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void destroy() {
    }
}