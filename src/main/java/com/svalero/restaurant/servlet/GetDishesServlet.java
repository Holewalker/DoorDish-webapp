/*package com.svalero.restaurant.servlet;

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
import java.util.List;

@WebServlet("/Dishes")
public class GetDishesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<head>\n" +
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\n" +
                "</head>");
        out.println("<div class='container'>");
        out.println("<h1>Listado de Platos</h1>");
        Database database = new Database();
        DishDao dishDao = new DishDao(database.getConnection());
        try {
            out.println("<ul class='list-group'>");
            List<Dish> dishes = dishDao.findAll();
            for (Dish dish : dishes ) {
                out.println("<li class='list-group-item'><a href='dish.jsp?id=" + dish.getId() + "'>" + dish.getName() + "</a></li>");
            }
            out.println("</ul>");
        } catch (SQLException sqle) {
            out.println("<h3>Se ha producido un error al cargar los datos de los Platos</h3>");
            sqle.printStackTrace();
        }
        out.println("</div>");
    }
}

*/