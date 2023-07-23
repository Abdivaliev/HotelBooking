package uz.sarvar.hotelbooking.controller;

import uz.sarvar.hotelbooking.ConnectionSource;
import uz.sarvar.hotelbooking.dao.BookingDAO;
import uz.sarvar.hotelbooking.dao.RoomDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "search", value = "/search-filter")
public class FilterController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String status = req.getParameter("status");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        String numberOfBeds = req.getParameter("numberOfBeds");

        System.out.println(status + "  " + startDate + "   " + endDate + "    " + numberOfBeds);

        try {
            BookingDAO bookingDAO = new BookingDAO(ConnectionSource.instance().createConnection());
            RoomDAO roomDAO = new RoomDAO(ConnectionSource.instance().createConnection());
            req.setAttribute("lists", roomDAO.getAllRooms());
            req.setAttribute("bookings", bookingDAO.getAllBookings());
            getServletContext().getRequestDispatcher("/admin.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("admin.jsp");
    }
}
