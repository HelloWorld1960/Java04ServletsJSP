<%-- 
    Document   : scriptlets
    Created on : May 10, 2019, 3:38:26 PM
    Author     : Panzer01

    -Scriptlets Contienen codigo Java (declaraciones de variables, llamadas a funciones ) que no necesariamente 
    visualizara el cliente, pero con una limitante de que no debe ser codigo muy robusto para no dificultar su 
    mantenimiento.
    Sintaxis: <% codigo %>
    El codgo generado mediente un Scriptlet se inserta dentro del metodo service del servlet generado a partir del JSP 
    que se compilo.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con ScripletsPage</title>
    </head>
    <body>
        <h1>JSP con Scriplets</h1>
        <br>
        <!--Scriplet para enviar informacion al navegador-->
        <%
            out.println("Saludos desde un scriplet");
        %>
        <br>
        <!-- Scriplet para manipular los objetos implicitos-->
        <%
            String nombreAplicacion = request.getContextPath();
            out.println("nombreAplicacion:" + nombreAplicacion);
        %>
        <br>
        <!--Scriplet con codigo condicionado -->
        <%
            if (session != null && session.isNew()) {
        %>
        la sesion SI es nueva
        <%
        } else if (session != null) {
        %>
        la sesion NO es nueva
        <%
        }
        %>
    </body>
</html>
