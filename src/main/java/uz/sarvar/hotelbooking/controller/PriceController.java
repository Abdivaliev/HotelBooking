package uz.sarvar.hotelbooking.controller;

import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "price", value = "/price")
public class PriceController extends HttpServlet {
    private String message;

    public void init() {

        message = "Hello World!";
    }
    @SneakyThrows
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.sendRedirect("/login.jsp");
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