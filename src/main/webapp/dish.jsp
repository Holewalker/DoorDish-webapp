<%@ page import="com.svalero.restaurant.dao.Database" %>
<%@ page import="com.svalero.restaurant.dao.DishDao" %>
<%@ page import="com.svalero.restaurant.domain.Dish" %>
<%@ page import="com.svalero.restaurant.domain.Restaurant" %>
<%@ page import="com.svalero.restaurant.dao.RestaurantDao" %>
<%@ page import="java.util.Optional" %>
<%@ page import="java.sql.SQLException" %>

 <%
        String dishId = request.getParameter("id_dish");
        Database db = new Database();
        DishDao dishDao = new DishDao(db.getConnection());
        RestaurantDao restaurantDao = new RestaurantDao(db.getConnection());
        Dish dish = null;
        Restaurant restaurant = null;
        String restaurantId = "0";


        try {
            Optional<Dish> optionalDish = dishDao.findById(Integer.parseInt(dishId));
            dish = optionalDish.get();
            restaurantId = dish.getRestaurant();
            Optional<Restaurant> optionalRestaurant = restaurantDao.findById(restaurantId);
            restaurant = optionalRestaurant.get();

    %>
<!doctype html>
<html lang="es">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
     <link href="css/style.css" rel="stylesheet">
     <title><%= dish.getName() %></title>
</head>
<body>

    <div class="container">
        <div class="card text-center">
          <div class="card-header">
            Detalles del plato
          </div>
          <div class="card-body">
            <h5 class="card-title"><%= dish.getName() %></h5>
            <p class="card-text">Servido por <strong><%= restaurant.getName() %></strong></p>
            <a href="buy?id=<%= dish.getId() %>" class="btn btn-primary">Pedir</a>
          </div>
          <div class="card-footer text-muted">
            Tipo de comida: <strong><%= dish.getType() %></strong>
          </div>
           <div class="card-footer text-muted">
            Precio: <strong><%= dish.getPrice() %></strong>
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
