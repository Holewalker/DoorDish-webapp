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

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2>Listado de Platos</h2>
        <ul class="list-group">
            <%
                // Acceder a la base de datos y recuperar la información de los libros
                Database database = new Database();
                DishDao dishDao = new DishDao(database.getConnection());
                RestaurantDao restaurantDao = new RestaurantDao(database.getConnection());

                try {
                    ArrayList<Dish> dishes = dishDao.findAll();

                    for (Dish dish : dishes) {
                    String restaurantId = dish.getRestaurant();
                    Restaurant restaurant = null;
                    Optional<Restaurant> optionalRestaurant = restaurantDao.findById(restaurantId);
                    restaurant = optionalRestaurant.get();


            %>
                          <li class="list-group-item list-group-item-action d-flex justify-content-between align-items-center">
                            <a target="_blank" href="dish.jsp?id_dish=<%= dish.getId() %>"><%= dish.getName() %></a>

                            <a target="_blank" href="restaurant.jsp?id_restaurant=<%= dish.getRestaurant() %>">
                            <%= restaurant.getName()%></a>
                            <%
                                if ((currentUser != null) && (currentUser.getRole().equals("DEV"))) {
                            %>
                                  <span class="tab"></span>  <a target="_blank" href="delete-dish?id=<%= dish.getId() %>" class="btn btn-outline-danger">Eliminar</a>
                            <%
                                }
                            %>
                        </li>

                         <li class="list-group-item list-group-item-action flex-column align-items-start">
                            <a target="_blank" href="dish.jsp?id_dish=<%= dish.getId() %>"> <%= dish.getName() %></a>
                            <a target="_blank" href="restaurant.jsp?id_restaurant=<%= dish.getRestaurant() %>">
                            <%= restaurant.getName()%></a>
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