package uz.sarvar.hotelbooking.controller;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import uz.sarvar.hotelbooking.ConnectionSource;
import uz.sarvar.hotelbooking.dao.BookingDAO;
import uz.sarvar.hotelbooking.dao.UserDAO;
import uz.sarvar.hotelbooking.util.Role;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;


@WebServlet(name = "login", value = "/login")
public class LoginController extends HttpServlet {
    private UserDAO userDAO = UserDAO.getInstance();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            boolean isValid = userDAO.validateAdmin(username, password, Role.ADMIN.name());
            if (isValid) {
                resp.sendRedirect("/admin");
            } else {
                resp.sendRedirect("/login");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}