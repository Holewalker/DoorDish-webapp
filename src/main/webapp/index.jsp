<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"

    import="com.svalero.restaurant.domain.User"
%>

    <%
    User currentUser = (User) session.getAttribute("currentUser");
    if (currentUser == null) {
        response.sendRedirect("login.jsp");
    }
%>

        <jsp:include page="header.jsp" />

        <body>
            <div class="container">
                <h2>Doordish-Dishes to your door!</h2>
                <ul>
                    <li><a href="/restaurant/Dishes.jsp">Ver Platos</a></li>
                    <li><a href="/restaurant/searchdish.jsp">Buscar Platos</a></li>
                    <li><a href="/restaurant/restaurants.jsp">Ver Restaurantes</a></li>
                                       <%
            if ((currentUser != null) && (currentUser.getRole().equals("DEV"))) {
        %>
                        <li><a href="/restaurant/adddish.jsp">Registrar un Plato</a></li>
                                                <%
            }
            if (currentUser != null) {
        %>
                            <li><a href="/restaurant/logout">Cerrar sesión</a></li>
                            <%
            }
        %>
                </ul>
                <br/>
                <div class="alert alert-success" role="alert">
                    Bienvenido
                    <% if (currentUser != null) out.print(currentUser.getName()); %>
                </div>
            </div>
        </body>

        </html>