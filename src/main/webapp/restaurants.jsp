<%@ page import="com.svalero.restaurant.dao.Database" %>
<%@ page import="com.svalero.restaurant.dao.DishDao" %>
<%@ page import="com.svalero.restaurant.domain.Dish" %>
<%@ page import="com.svalero.restaurant.domain.Restaurant" %>
<%@ page import="com.svalero.restaurant.dao.RestaurantDao" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.Optional" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.svalero.restaurant.domain.User" %>

<%
    User currentUser = (User) session.getAttribute("currentUser");
    if (currentUser == null) {
        response.sendRedirect("login.jsp");
    }
%>
<!doctype html>
<html lang="es">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href="css/style.css" rel="stylesheet">
    <title>Listado de platos</title>
</head>
<body>
    <div class="container">
        <h2>Listado de Platos</h2>
        <div class="list-group">
            <%

                Database database = new Database();
                RestaurantDao restaurantDao = new RestaurantDao(database.getConnection());

                try {
                    ArrayList<Restaurant> restaurants = restaurantDao.findAll();

                    for (Restaurant restaurant : restaurants) {

            %>

                 <div class="list-group-item list-group-item-action flex-column align-items-start">
                    <div class="d-flex w-100 justify-content-between">
                        <a target="_blank" href="restaurant.jsp?id_restaurant=<%= restaurant.getId() %>">
                            <h5 class="mb-1"> <%= restaurant.getName() %></h5>
                        </a>
                    </div>
                   </div>
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
        </div>
    </div>
</body>
</html>