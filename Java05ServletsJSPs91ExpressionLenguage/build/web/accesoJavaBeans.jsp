<%-- 
    Document   : accesoJavaBeans
    Created on : May 17, 2019, 8:22:02 PM
    Author     : Panzer01
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acceso a JavaBeans</title>
    </head>
    <body>
        <h1>Acceso a JavaBeans</h1>

        <!-- Creamos un objeto(instanciar) de tipo JavaBean llamado Rectangulo, que es tipo Rectangulo en el 
        paquete beans. No especificamos alcance, pero se intulle que es page.-->
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" />

        <!-- Asignamos los valores del formulario al JavaBean -->
        <jsp:setProperty name="rectangulo" property="*" />
        <!-- Utilizamos la sintaxis expression lenguage para acceder a las propiedades del JavaBean. -->
        <br>
        Valor base: ${rectangulo.base}
        <br>
        Valor altura: ${rectangulo.altura}
        <br>
        Valor Area: ${rectangulo.area}
        <br>
        Calculo del Area: ${rectangulo.base*rectangulo.altura}

        <br>
        <br>
        <a href="index.jsp">Regresar al Inicio</a>

    </body>
</html>
