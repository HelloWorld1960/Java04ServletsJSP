<%--Patron de diseño MVC(Modelo-Vista-Controlador).
    Su principal funcion es separar la VISTA(JSPs) de los datos y unirlos por medio de un CONTROLADOR(Servlets).
    -Los servlets estan enfocados en controlar el flujo de la peticion HTTP, asi como utilizar los JavaBeans 
    para almacenar informacion y finalmente redireccionar al JSP respectivo.
    -Los JSPs estan enfocados en desplegar la informacion de la aplicacion web, en este caso la informacion es 
    proveida por medio de los servlets y la informacion que se comparte entre los Servlets y JSPs suele manejarse 
    con JavaBean.
    -El patron de diseño MVC(Modelo Vista Controlador) nos permite integrar a los JSPs(VISTA), a los Servlets(Controlador) 
    y a los JavaBeans(Modelo). --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo MVC 2</title>
    </head>
    <body>
        <h1>Ejemplo MVC 2</h1>
        <!-- Utilizamos expression lenguage para acceder al mensaje que comparte el ServletControlador -->
        <div style="color:red"> ${mensaje} </div>
        <br>
        <!-- Utilizamos expression lenguage para acceder a la ruta. -->
        <a href="${pageContext.request.contextPath}/ServletControlador">
            Link al servlet controlador sin parametros
        </a>
        <br><br>
        <!-- Utilizamos expression lenguage para acceder a la ruta, pero enviando un parametro de accion. -->
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=agregaVariables">
            Link al servlet controlador para agregar las variables
        </a>
        <br><br>
        <!-- Utilizamos expression lenguage para acceder a la ruta, pero enviando un parametro de accion. -->
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=listarVariables">
            Link al servlet controlador para listar las variables
        </a>
    </body>
</html>
