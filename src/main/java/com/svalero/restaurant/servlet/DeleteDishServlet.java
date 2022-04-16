package com.svalero.restaurant.servlet;

import com.svalero.restaurant.dao.Database;
import com.svalero.restaurant.domain.User;
import com.svalero.restaurant.dao.DishDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/delete-dish")
public class DeleteDishServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if (currentUser == null) {
            response.sendRedirect("accesonopermitido.jsp");
        }

        // TODO Eliminar el libro cuyo id se para como parametro


        String id = request.getParameter("id");
        Database database = new Database();
        DishDao dishDao = new DishDao(database.getConnection());
        try {
            dishDao.delete(id);
        } catch (SQLException sqle) {
            out.println("<div class='alert alert-danger' role='alert'>Se ha producido un error al registrar el Plato</div>");
            sqle.printStackTrace();
        }
    }
}