<%-- 
    Document   : setterAllParamsJSP
    Created on : May 15, 2019, 6:05:18 PM
    Author     : Panzer01
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP que modifica a  un JavaBean por Par&aacute;metros</title>
    </head>
    <body>
        <h1>JSP que modifica a  un JavaBean por Par&aacute;metros</h1>

        <!--Declaramos el JavaBean a utilizar-->
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />

        <!--Modificamos todas las propiedades cuyo parametro
        coincida con el nombre de la propiedad.
        Ya no se necesita especificar el nombre del parametro del formulario, unicamente con que coincida el 
        nombre de la propiedad con el nombre del parametro que se envia atravez de HTML, entonces se asigna 
        en automatico al nombre del parametro de la propiedad del Java Bean.-->
        <jsp:setProperty name="rectangulo" property="*" />

        Se modificaron todos los atributos:
        <br>
        <br>

        Nuevo valor base: <%= request.getParameter("base") %>
        <br>
        Nuevo valor altura: <%= request.getParameter("altura") %>
        <br>
        <br>
        <a href="index.jsp">Regresar al Inicio</a>
    </body>
</html>
