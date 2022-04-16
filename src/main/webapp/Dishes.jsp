<%@ page import="com.svalero.restaurant.dao.Database" %>
<%@ page import="com.svalero.restaurant.dao.DishDao" %>
<%@ page import="com.svalero.restaurant.domain.Dish" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.svalero.restaurant.domain.User" %>

<%
    User currentUser = (User) session.getAttribute("currentUser");
    if (currentUser == null) {
        response.sendRedirect("login.jsp");
    }
%>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h2>Listado de Platos</h2>
        <ul class="list-group">
            <%
                // Acceder a la base de datos y recuperar la información de los libros
                Database database = new Database();
                DishDao dishDao = new DishDao(database.getConnection());
                try {
                    ArrayList<Dish> dishes = dishDao.findAll();
                    for (Dish dish : dishes) {

            %>
                          <li class="list-group-item">
                            <a target="_blank" href="dish.jsp?id_dish=<%= dish.getId() %>"><%= dish.getName() %></a>
                            <%
                                if ((currentUser != null) && (currentUser.getRole().equals("DEV"))) {
                            %>
                                    <a target="_blank" href="delete-dish?id=<%= dish.getId() %>" class="btn btn-outline-danger">Eliminar</a>
                            <%
                                }
                            %>
                        </li>
            <%
                    }
               } catch (SQLException sqle) {
                 sqle.printStackTrace();
            %>
                    <div class="alert alert-danger" role="alert">
                      Error conectando con la base de datos
                    </div>
            <%
               }
            %>
        </ul>
    </div>
</body>
</html>