<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>

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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
    <script type="text/javascript">
        $(document).ready(function() {
            $("form").on("submit", function(event) {
                event.preventDefault();
                var formValue = $(this).serialize();
                $.post("add-dish", formValue, function(data) {
                    $("#result").html(data);
                });
            });
        });
    </script>
    <div class="container">
        <h2>Registro de un Plato</h2>
        <form>
            <div class="mb-2">
                <label for="dname" class="form-label">Nombre</label>
                <input name="dname" type="text" class="form-control w-25" id="name">
            </div>
            <div class="mb-3">
                <label for="ID_restaurant" class="form-label">ID Restaurante (WIP)</label>
                <input name="ID_restaurant" type="text" class="form-control w-25" id="restaurant">
            </div>
            <div class="mb-2">
                <label for="dtype" class="form-label">Tipo</label>
                <input name="dtype" type="text" class="form-control w-25" id="type">
            </div>
             <div class="mb-2">
                <label for="price" class="form-label">Precio</label>
                <input name="price" type="text" class="form-control w-25" id="price">
            </div>
            <button type="submit" class="btn btn-primary">Registrar</button>
        </form>
        <div id="result"></div>
    </div>
</body>
</html>
