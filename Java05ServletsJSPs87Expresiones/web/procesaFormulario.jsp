<%-- 
    Document   : procesaFormulario
    Created on : May 10, 2019, 2:04:50 PM
    Author     : Panzer01

    -Expressions: Se conoce como tag o etiqueta de expresion.
    Sintaxis: <%= expresion %>
    La expresion puede ser cualquier expresion valida(cadena, expresion matematica o el resultado de una llamada a 
    una funcion.) que sera equivalente a poner out.println().
    La expresion se evalua y se inserta en la salida del servlet.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Procesa Formulario</title>
    </head>
    <body>
        <h1>Resultado de Procesar Formulario</h1>
        Usuario: <%= request.getParameter("usuario") %>
        <br>
        Password: <%= request.getParameter("password") %>
        <br>
        <br>
        <a href="index.html">Regresar al inicio </a>
    </body>
</html>
