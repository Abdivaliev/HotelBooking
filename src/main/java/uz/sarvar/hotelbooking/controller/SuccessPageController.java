package uz.sarvar.hotelbooking.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "success", value = "/success")
public class SuccessPageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message","success");
        getServletContext().getRequestDispatcher("/success-page.jsp").forward(req,resp);
    }
}
