<%-- 
    Document   : fondoColor
    Created on : May 10, 2019, 3:38:07 PM
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
<%
    String fondo = request.getParameter("colorFondo");
    //Si no se envio un color, ponemos un color por default
    //Si fondo es igual a null o es una cadena vacia.
    if (fondo == null || fondo.trim().equals("")) {
        fondo = "white";
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Cambio de Color de Fondo</title>
    </head>
    <body bgcolor="<%=fondo%>">
        <h1>Fondo de color aplicado: <%= fondo%></h1>
        <br>
        <a href="index.html">Regresar al Index</a>
    </body>
</html>
