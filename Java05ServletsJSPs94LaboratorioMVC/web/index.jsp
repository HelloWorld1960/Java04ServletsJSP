<%--Patron de diseño MVC(Modelo-Vista-Controlador).
    Su principal funcion es separar la VISTA(JSPs) de los datos y unirlos por medio de un CONTROLADOR(Servlets).
    Los servlets estan enfocados en controlar el flujo de la peticion HTTP, asi como utilizar los JavaBeans 
    para almacenar informacion y finalmente redireccionar al JSP respectivo.
    -Los JSPs estan enfocados en desplegar la informacion de la aplicacion web, en este caso la informacion es 
    proveida por medio de los servlets y la informacion que se comparte entre los Servlets y JSPs suele manejarse 
    con JavaBean.
    -El patron de diseño MVC(Modelo Vista Controlador) nos permite integrar a los JSPs(VISTA), a los Servlets(Controlador) 
    y a los JavaBeans(Modelo). --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Laboratorio MVC</title>
    </head>
    <body>
        <h1>Laboratorio MVC</h1>
        <br>
        <!-- Utilizamos expression lenguage para acceder a la ruta. -->
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=listado">
            Link al servlet Controlador que lista a las personas</a>
        <br>
        <!-- Utilizamos expression lenguage para acceder a la ruta. -->
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=login">
            Login</a>
        <br>
    </body>
</html>
