package uz.sarvar.hotelbooking.controller;

import lombok.SneakyThrows;
import uz.sarvar.hotelbooking.ConnectionSource;
import uz.sarvar.hotelbooking.dao.BookingDAO;
import uz.sarvar.hotelbooking.dao.RoomDAO;
import uz.sarvar.hotelbooking.model.Room;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "admin", value = "/admin")
public class AdminController extends HttpServlet {
    private String message;

    public void init() {

        message = "Hello World!";
    }
    @SneakyThrows
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            BookingDAO bookingDAO = new BookingDAO(ConnectionSource.instance().createConnection());
            RoomDAO roomDAO  = new RoomDAO(ConnectionSource.instance().createConnection());
            request.setAttribute("lists",roomDAO.getAllRooms());
            request.setAttribute("bookings",bookingDAO.getAllBookings());
            getServletContext().getRequestDispatcher("/admin.jsp").forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("username"));
        System.out.println(req.getParameter("password"));
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("tizimga xush kelibsiz");

    }

    public void destroy() {
    }
}