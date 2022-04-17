<%@ page import="com.svalero.restaurant.dao.Database" %>
<%@ page import="com.svalero.restaurant.dao.DishDao" %>
<%@ page import="com.svalero.restaurant.domain.Dish" %>
<%@ page import="com.svalero.restaurant.dao.RestaurantDao" %>
<%@ page import="com.svalero.restaurant.domain.Restaurant" %>
<%@ page import="java.util.Optional" %>
<%@ page import="java.sql.SQLException" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <%
        String restaurantId = request.getParameter("id_restaurant");
        Database db = new Database();
        RestaurantDao restaurantDao = new RestaurantDao(db.getConnection());
        Restaurant restaurant = null;
        try {
            Optional<Restaurant> optionalRestaurant = restaurantDao.findById(restaurantId);
            restaurant = optionalRestaurant.get();

    %>
    <div class="container">
        <div class="card text-center">
          <div class="card-header">
            Detalles del restaurante
          </div>
          <div class="card-body">
            <h5 class="card-title"><%= restaurant.getName() %></h5>
            <p class="card-text">Nacionalidad: <strong><%= restaurant.getNation() %></strong></p>
         </div>
          <div class="card-footer text-muted">
            Valoracion: <strong><%= restaurant.getStars() %></strong>
          </div>
                   </div>
    </div>
    <%
        } catch (SQLException sqle) {
    %>
        <div class='alert alert-danger' role='alert'>Se ha producido al cargar los datos del plato</div>
    <%
        }
    %>
</body>
</html>
