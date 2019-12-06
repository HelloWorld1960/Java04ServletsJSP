<%--Patron de diseño MVC(Modelo-Vista-Controlador).
    Su principal funcion es integrar la VISTA(JSPs) de los datos(MODELO) y unirlos por medio de un CONTROLADOR(Servlets).
    -Los servlets estan enfocados en controlar el flujo de la peticion HTTP, asi como utilizar los JavaBeans 
    para almacenar informacion y finalmente redireccionar al JSP respectivo.
    -Los JSPs estan enfocados en desplegar la informacion de la aplicacion web, en este caso la informacion es 
    proveida por medio de los servlets y la informacion que se comparte entre los Servlets y JSPs suele manejarse 
    con JavaBean.
    -El patron de diseño MVC(Modelo Vista Controlador) nos permite integrar a los JSPs(VISTA), a los Servlets(Controlador) 
    y a los JavaBeans(Modelo).--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo MVC</title>
    </head>
    <body>
        <h1>Ejemplo MVC</h1>
        <br>
        <!-- Utilizamos expression lenguage para acceder a la ruta. -->
        <a href="${pageContext.request.contextPath}/ServletControlador">
            Link al servlet controlador que despliega las variables
        </a>
    </body>
</html>
