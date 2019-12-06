<%-- 
    Document   : jstlCore
    Created on : May 18, 2019, 3:32:59 PM
    Author     : Panzer01
--%>

<!-- Con esta directiva importamos la libreria de core JSTL -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Core</title>
    </head>
    <body>
    <h1>JSTL Core</h1>

    <!-- Manipulacion Variables -->
    <c:set var="nombre" value="panzer01" />
    Variable nombre: <c:out value="${nombre}" />

    <br>
    <br>

    Variable con c&oacute;digo html:
    <c:out value="<h1>Hola</h1>" escapeXml="true" />

    <br>
    <br>

    <!-- Codigo condicionado, uso del if -->
    <c:set var="bandera" value="true" />

    <c:if test="${bandera}" >
      La bandera es verdadera
    </c:if>

    <br>
    <!-- codigo condicionado, similar al switch -->
    <!-- Si el parametro recibido opcion es diferente de nulo, entonces realiza lo siguiente. -->
    <c:if test="${param.opcion != null}">
      <c:choose>
        <c:when test="${param.opcion == 1}">
          <br>
          Opcion 1 proporcionada
          <br>
        </c:when>
        <c:when test="${param.opcion == 2}">
          <br>
          Opcion 2 proporcionada
          <br>
        </c:when>
        <c:otherwise>
          <br>
          Opcion proporcionada desconocida: ${param.opcion}
          <br>
        </c:otherwise>
      </c:choose>
    </c:if>

    <!--Iteracion de un arreglo -->
    <%
        //Uso de Scriptlet
        //Craemos el arreglo con un scriplet (aunque no es buena practica, debido a que los servlets son los que 
        //tienen que asignar los valores del arreglo.)
        String nombres[] = {"Claudia", "Pedro", "Carlos", "Ana"};
        //Compartimos el arreglo de nombres en el alcance(scope) de request, 
        //para poder tener acceso a travez de JSTL y tambien Expression Lenguage.
        request.setAttribute("nombres", nombres);
    %>

    <br>
    Lista de Nombres en el arreglo:
    <br>
    <ul>
        <!-- status hace referencia a el indice. -->
      <c:forEach varStatus="status" var="persona" items="${nombres}">
          <!-- status.count hace referencia a el indice que se esta iterando.. -->
        <li>${status.count} - Nombre: ${persona}</li>
      </c:forEach>
    </ul>

    <br>
    <a href="index.jsp">Regresar al Inicio</a>
  </body>
</html>
