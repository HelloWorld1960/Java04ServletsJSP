<!--JavaServer Pages API permiten definir tags personalizados JSP, en este caso se usan librerias JSTL()
    que permiten trabajar de mejor forma la parte la vista, haciendo uso de tags, permite acceder a los Java Bean 
    de nuestra aplicacion de una forma muy simple, ademas permite usar condiciones, iterar listas, manipular 
    archivos xml, manipular consultas sql, entre otras. 
    Una vez que se añade la libreria JST al proyecto, es necesario añadir una directiva en las paginas JSP 
    en las que queremos hacer uso de la misma.-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="der">
  <!-- Utilizamos expression lenguage para Operador Ternario(if corto). -->
  ${usuario!=null ? "Bienvenido " : ""}
</div>

<div class="izq">
  <!-- Utilizamos expression lenguage para acceder a la ruta. -->
  <a href="${pageContext.request.contextPath}/index.jsp">
    Inicio
  </a>
  &nbsp;
  <!--Etiqueta condicional que evalua si usuario es diferente de null. -->
  <c:if test="${usuario != null}" >
    &nbsp;
    <!-- Utilizamos expression lenguage para acceder a la ruta. -->
    <a href="${pageContext.request.contextPath}/ServletControlador?accion=salir">
      Salir
    </a>
  </c:if>
</div>