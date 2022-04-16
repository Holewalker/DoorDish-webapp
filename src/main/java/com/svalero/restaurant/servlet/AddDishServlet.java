package com.svalero.restaurant.servlet;

import com.svalero.restaurant.dao.DishDao;
import com.svalero.restaurant.dao.Database;
import com.svalero.restaurant.domain.Dish;
import com.svalero.restaurant.domain.User;
import com.svalero.restaurant.exception.DishAlreadyExistException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/add-dish")
public class AddDishServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if (currentUser == null) {
            response.sendRedirect("accesonopermitido.jsp");
        }

        String title = request.getParameter("title");       // input name="title" del formulario
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
        String price = request.getParameter("price");
        Dish dish = new Dish(title, author, publisher, price);

        Database database = new Database();
        DishDao bookDao = new DishDao(database.getConnection());
        try {
            bookDao.add(dish);
            out.println("<div class='alert alert-success' role='alert'>El libro se ha registrado correctamente</div>");
        } catch (DishAlreadyExistException baee) {
            out.println("<div class='alert alert-danger' role='alert'>El libro ya existe en la base de datos</div>");
            baee.printStackTrace();
        } catch (SQLException sqle) {
            out.println("<div class='alert alert-danger' role='alert'>Se ha producido un error al registrar el libro</div>");
            sqle.printStackTrace();
        }
    }
}