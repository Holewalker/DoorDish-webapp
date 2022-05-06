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

        String name = request.getParameter("dname");
        String restaurant = request.getParameter("ID_restaurant");
        String type = request.getParameter("dtype");
        String price = request.getParameter("price");
        Dish dish = new Dish(name, restaurant, type, price);

        Database database = new Database();
        DishDao dishDao = new DishDao(database.getConnection());
        try {
            dishDao.add(dish);
            out.println("<div class='alert alert-success' role='alert'>El plato se ha registrado correctamente</div>");
        } catch (DishAlreadyExistException daee) {
            out.println("<div class='alert alert-danger' role='alert'>El plato ya existe en la base de datos</div>");
            daee.printStackTrace();
        } catch (SQLException sqle) {
            out.println("<div class='alert alert-danger' role='alert'>Se ha producido un error al registrar el Plato</div>");
            sqle.printStackTrace();
        }
    }
}