package com.svalero.restaurant.servlet;

import com.svalero.restaurant.dao.DishDao;
import com.svalero.restaurant.dao.Database;
import com.svalero.restaurant.domain.Dish;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/search-dish")
public class SearchDishesServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String searchText = request.getParameter("searchtext");

        Database database = new Database();
        DishDao dishDao = new DishDao(database.getConnection());
        try {
            ArrayList<Dish> dishes = dishDao.findAll(searchText);
            StringBuilder result = new StringBuilder("<ul class='list-group'>");
            for (Dish dish : dishes) {
                result.append("<li class='list-group-item'>").append(dish.getName()).append("</li>");
            }
            result.append("</ul>");
            out.println(result);
        } catch (SQLException sqle) {
            out.println("<div class='alert alert-danger' role='alert'>Se ha producido un error durante la búsqueda</div>");
            sqle.printStackTrace();
        }
    }
}