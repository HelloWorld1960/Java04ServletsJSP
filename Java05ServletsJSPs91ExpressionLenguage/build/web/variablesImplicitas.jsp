<%-- 
    Document   : variablesImplicitas
    Created on : May 17, 2019, 8:22:28 PM
    Author     : Panzer01
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>El(Expressions Lenguage) y Variables Implicitas</title>
    </head>
    <body>
        <h1>EL y Variables Implicitas</h1>

        <ul>
            <!-- Utilizando los Objetos implicitos de Expression Lenguage -->
            <li>Nombre Aplicaci&oacute;n: ${pageContext.request.contextPath}</li>
            <li>Navegador del Cliente: ${header["User-Agent"]}
            <li>Id Session: ${cookie.JSESSIONID.value}</li>
            <li>Web Server: ${pageContext.servletContext.serverInfo}
            <li>Valor Par&aacute;metro Usuario: ${param["usuario"]}</li>
        </ul>

        <br>
        <br>
        <a href="index.jsp">Regresar al Inicio</a>

    </body>
</html>
