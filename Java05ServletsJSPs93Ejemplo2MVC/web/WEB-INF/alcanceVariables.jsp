<%-- 

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alcance de Variables</title>
    </head>
    <body>
        <h1>Alcance de Variables</h1>
        <br>
        Variable request: 
        <!-- Estas son las variables que vamos a acceder del ServletControlador.
             Utilizamos expression lenguage para especificar el objeto a acceder del JSP, en este caso en el alcance de 
             REQUEST.-->
        Base: ${rectanguloRequest.base}
        Altura: ${rectanguloRequest.altura}
        Area: ${rectanguloRequest.area}
        <br><br>
        <!-- Utilizamos expression lenguage para especificar el objeto a acceder del JSP, en este caso en el alcance de 
             SESSION.-->
        Variable session: 
        Base: ${rectanguloSession.base}
        Altura: ${rectanguloSession.altura}
        Area: ${rectanguloSession.area}

        <br><br>
        <!-- Utilizamos expression lenguage para especificar el objeto a acceder del JSP, en este caso en el alcance de 
             APPLICATION.-->
        Variable application: 
        Base: ${rectanguloApplication.base}
        Altura: ${rectanguloApplication.altura}
        Area: ${rectanguloApplication.area}
        <br><br>
        <!-- Utilizamos expression lenguage para acceder a la ruta. -->
        <a href="${pageContext.request.contextPath}/index.jsp">
            Regresar al inicio
        </a>
    </body>
</html>
