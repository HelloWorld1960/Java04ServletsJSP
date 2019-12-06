<%-- VISTA:
    Los JSP se encargaran de acceder a la informacion que comparte los servlets, por ello los JSP juegan el papel de la 
    vista.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Despliegue de Variables</title>
    </head>
    <body>
        <h1>Despliegue de Variables</h1>

        <!-- Utilizando expression lenguage accedemos al objeto mensaje proveniente de ServletControlador-->
        Variable en alcance request:
        ${mensaje}

        <br>
        <br>

        Variable en alcance session:
        <br>
        <!-- Utilizando expression lenguage accedemos al objeto rectangulo y a los metodos GET del JavaBean, proveniente 
        de ServletControlador-->
        Rectangulo:
        Base: ${rectangulo.base} 
        Altura: ${rectangulo.altura}
        Area: ${rectangulo.area}

        <br>
        <br>
        <a href="${pageContext.request.contextPath}/index.jsp">
            Regresar al Inicio
        </a>
    </body>
</html>
