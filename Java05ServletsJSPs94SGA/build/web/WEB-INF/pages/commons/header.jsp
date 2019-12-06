<%-- Prevencion del cache --%>
<%
    response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server
    response.setHeader("Cache-Control", "no-store");
%>
<!-- Utilizamos expression lenguage para incluir los estilos. -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/estilos.css"/>

<!-- Utilizamos expression lenguage para incluir el archivo javascript. -->
<script language="javascript" src="${pageContext.request.contextPath}/resources/funciones.js"></script>

<div class="titulo">
  Sistema de Gesti&oacute;n
  <br> de Alumnos (SGA)
</div>

<!--El logo de Global Mentoring se agrega mediante css. -->
