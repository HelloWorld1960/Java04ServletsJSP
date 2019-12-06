<%-- 
    Document   : index
    Created on : May 10, 2019, 2:01:37 PM
    Author     : Panzer01

    -Expressions: Se conoce como tag o etiqueta de expresion.
    Sintaxis: <%= expresion %>
    La expresion puede ser cualquier expresion valida(cadena, expresion matematica o el resultado de una llamada a 
    una funcion.) que sera equivalente a poner out.println().
    La expresion se evalua y se inserta en la salida del servlet.
--%>

<!--Esto es una directiva.-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP de Expresiones</title>
    </head>
    <body>
        <h1>JSP de Expresiones</h1>
        Concatenaci&oacute;n: <%= "Saludos" + "JSP" %>
        <br>
        Operaci&oacute;n Matem&aacute;tica: <%= "(2*3)/2= " + 2 * 3 / 2  %>
        <br>
        Session id: <%= session.getId() %>
        <br>
        <br>
        <a href="index.html">Regresar al inicio </a>
    </body>
</html>
