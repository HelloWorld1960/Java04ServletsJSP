<%-- 
    Document   : index
    Created on : May 13, 2019, 2:30:14 PM
    Author     : Panzer01
    Inclusion de archivos con JSP.
    Hace refenrecia a agregar un JSP dentro de otro.
    
    Inclusion Estatica(Traslation time).
    Se utiliza la directiva include: <%@include file="paginaRelativa.JSP" %>
    En este tipo de inclusion se genera un solo servlet que sera la combinacion del JSP principal y cada JSP que se 
    esta incluyendo en el JSP principal.
    Por lo anterior, se pueden tener variables o metodos que se comparten entre los JSPs.
    En el tiempo de traduccion(Translation time), el servlet generado incluye el contenido del JSP principal y del 
    JSP incluido utilizando el metodo out.write().
    El tiempo de Ejecucion(Request time) la salida HTML incluye el contenido del JSP principal y del 
    JSP incluido.

    Inclusion Dinamica(Request time).
    Se utiliza la accion include: <jsp:include page="paginaRelativa.JSP" />
    En este tipo de inclusion genera un servlet por cada JSP incluido en el JSP pincipal.
    Por lo anterior, No se comparten variables o metodos entre los JSPs, pero garantiza tener siempre la version mas 
    reciente. De igual manera se pueden incluir archivos privados que esten dentro de la carpeta WEB-INF.
    En el tiempo de traduccion(Translation time), genera un servlet por cada JSP incluido el JSP principal.
    El tiempo de Ejecucion(Request time), el servlet principal delega el control al servlet incluido para que se 
    ejecute  una ves terminada su ejecucion regresa el control al servlet principal para que se ejecute. Despues de 
    ejecutarse se vacia el contenido del JSP incluido dentro de la salida del JSP principal.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo Inclusion Estatica</title>
        <script type='text/JavaScript' src="recursos/funciones.js"></script>
        <link href="recursos/estilos.css" type="text/css" rel="stylesheet">
    </head>
    <body>
    <h1>Inclusi&oacute;n de Archivos Estáticos</h1>

    <!--Esto es por cada menu-->
    <br>
    <!--menu principal-->
    <span class="noticias" align="left">
      <a href="javascript:desplegar ('noticias');">
        <img border="0" src="http://icursos.net/cursos/ServletsJSPs/Leccion14/noticias.gif">
      </a>
    </span>
    
    <span id="noticias" class="ocultar_menu">
      <!--Submenu-->
      <ul>
          <!-- Utilizando inclusion estatica. -->
        <li><%@include file="pages/noticia1.html" %></li>
        <li><%@include file="pages/noticia2.html" %></li>
      </ul>
    </span>

     <!--Esto es por cada menu-->
    <br>
    <!--menu principal-->
    <span class="videos" align="left">
      <a href="javascript:desplegar ('videos');">
        <img border="0" src="http://icursos.net/cursos/ServletsJSPs/Leccion14/videos.gif">
      </a>
    </span>
    <span id="videos" class="ocultar_menu">
      <!--Submenu-->
      <ul>
          <!-- Utilizando inclusion estatica. -->
        <li><%@include file="pages/video1.html" %></li>
      </ul>
    </span>

  </body>
</html>
