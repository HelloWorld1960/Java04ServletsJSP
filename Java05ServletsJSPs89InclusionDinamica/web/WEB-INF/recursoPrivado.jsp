<%-- 
    Document   : recursoPrivado
    Created on : May 14, 2019, 9:38:51 PM
    Author     : Panzer01
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Scriplet -->
<%
    String colorFondo = request.getParameter("colorFondo");
    if ( colorFondo == null || colorFondo.trim().equals("")){
      colorFondo = "white"; //valor por default
    }
%>

<!-- Usando una expresion de JSP asignamos el color de fondo. -->
<body bgcolor="<%=colorFondo%>" >
  Despliegue del contenido desde un JSP privado en WEB-INF
</body>
