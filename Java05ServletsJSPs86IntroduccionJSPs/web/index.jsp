<%-- 
    Document   : index
    Created on : May 10, 2019, 10:32:49 AM
    Author     : Panzer01
    Los Java Servers Pages (JSPs) son componentes del lado del servidor web, los cuales se utilizan para manejar 
    codigo html e incrustar codigo java por medio de etiquetas conocidas como tags.
    Los JSPs son utilizados como metodo de presentacion, es decir son utilizados para mostrar informacion procesada 
    por componentes como los servlets.
    Al compilarse un JSP se crea un servlet asociado al este JSP, despues su ciclo de vida es igual al de un servlet.

    Elementos de un JSP.
    Un JSP se compone de Expressions, Scriptlets, Declaraciones y XMLX (una caracteristica que consiste en manejar una 
    sintaxis similar a XML).

    -Expressions: Se conoce como tag o etiqueta de expresion.
    Sintaxis: <%= expresion %>
    La expresion puede ser cualquier expresion valida(cadena, expresion matematica o el resultado de una llamada a 
    una funcion.) que sera equivalente a poner out.println().
    La expresion se evalua y se inserta en la salida del servlet.

    -Scriptlets Contienen codigo Java (declaraciones de variables, llamadas a funciones ) que no necesariamente 
    visualizara el cliente, pero con una limitante de que no debe ser codigo muy robusto para no dificultar su 
    mantenimiento.
    Sintaxis: <% codigo %>
    El codgo generado mediente un Scriptlet se inserta dentro del metodo service del servlet generado a partir del JSP 
    que se compilo.

    -Declaraciones:
    Sintaxis: <%! codigo Java %>
    Se utiliza para agregar codigo a la clase del Servlet generado.
    El codigo declarado, por ejemplo si se declara una variable, se vuelve una variable de instancia de la clase del 
    Servlet generado. Los metodos declarados tambien se vuelven parte la clase del Servlet generado.

    -XMLX:
    Cada elemento JSP tiene su equivalente en sintaxis XML.
    Es utilizado para tener mayor compativilidad con el lenguaje xml.

    Variables implicitas:
    Dentro de un JSP podemos utilizar objetos que ya estan instanciados para que podamos usarlos de manera inmediata.
    
    request: Es el objeto HTTPRequest.
    response: Es el objeto HTTPServletResponse.
    out: Es el objeto JspWritter (equivaente a printWritter).
    session: Es el objeto HTTPSession asociado con el objeto request.
    application: Es el objeto servlet context que se obtiene a partir del metodo getServletContext() en un servlet.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> <%-- Directiva que indica la codificacion del documento. --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <%-- Es un import de una libreria. --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hola Mundo JSP</title>
    </head>
    <body>
    <h1>Ejercicio de Hola Mundo con JSPs</h1>
    <!--Impresion de cadenas con diferentes tecnologias-->
    <ul>
      <li> Hola Mundo con HTML
      <li> <% out.print("Hola Mundo con Scriptlets");%>
      <li> ${"Hola Mundo con Expression Language (EL)"}
      <li> <c:out value="Hola Mundo con JSTL (JSP Standar Tag Library)" />
    </ul>
    <!-- Algunos valores del lado del servidor -->
    <ul>
      <!-- Utilizar exprecion para imprimir un valor, es como usar el metodo print del objeto Out. 
           El concepto de Objetos implicitos permite el uso de el objeto request, el cual esta disponible para su uso. -->
      <li> Hola: <%= new java.util.Date()%>  
      <li> Nombre del Contexto de la aplicaci&oacute;n:
        <%= request.getContextPath()%>
      <li> Valor del par&aacute;metro x:
        <%= request.getParameter("x")%>
    </ul>
  </body>
</html>
