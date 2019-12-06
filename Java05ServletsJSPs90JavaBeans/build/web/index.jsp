<%-- 
    Document   : index
    Created on : May 15, 2019, 6:03:29 PM
    Author     : Panzer01
    Java Beans:
    Un Java Bean es una clase de Java que tiene las siguientes caracterizticas.
    -Debe tener un constructor vacio.
    -Todos los atributos deben ser privados.
    -Se debe generar el metodo get y set para cada atributo.

    Los JSPs pueden acceder a los atributos de un Java Bean utilizando el nombre de la pripoedad, esto lo hace 
    llamando al metodo get o set asociada al atributo.

    Ejemplo: Para llamar a un atributo se deben definir los metodos get y set en el Java Bean.
    Nombre de la propiedad: nombreUsuario.
    Nombre de los metodos: getNombreUsuario(), setNombreUsuario().
    Codigo en JSP: Utilizando una accion.
                  <jsp:getProperty ... property:"nombreUsuario"/>
                  <jsp:setProperty ... property:"nombreUsuario"/>

    Alcance de atributo en un JSP (SCOPE).
    El alcance de una variable es la duracion o tiempo de uso de una variable en una aplicacion web. 
    Se tienen cuatro alcances(scope), los cuales son page, request, session, application.
    Page: Su alcance es solo dentro de los JSP, es decir dentro del tiempo de traduccion(Translation time) de un JSP a 
    un Servlet.
    Request: Las variables en este alcance unicamente van a existir durante el tiempo en que un usuario haga una 
    peticion a el servidor web. Una vez que la informacion llega al servidor esta se destrulle.
    Session: Una variable agregada en este alcance va a durar durante distintas peticiones a nuestro servidor web, 
    por lo menos durante el tiempo que dure la sesion.
    Application: Cuando se agrega informacion a este alcance de aplication entonces exitira durante todo el tiempo que 
    se ejecute la aplicacion web y se destruira hasta que termine de ejecutar o se haga un deploy al servidor.

    Uso Basico de los Java Beans desde los JSPs:
    jsp:useBean: Permite acceder a un Bean en un alcance(scope) especificado. En caso de no especificar el alcance, 
    por default se toma que es page.
    El nombre de la variable JavaBean se define con el atributo id.
    <jsp:useBean id:"nombreBean" class=""paquete.NombreClase/>
    
    jsp:setProperty: Permite modificar una o varias propiedades de un Bean especificado.
    <jsp:setProperty name:"nombreBean" property:"nombreUsuario" value:"Juan" />
    
    jsp:getProperty: Permite acceder una o varias propiedades de un Bean especificado.
    <jsp:getProperty name:"nombreBean" property:"nombreUsuario" />
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo JavaBeans</title>
    </head>
    <body>
        <h1>Ejemplo de JavaBeans</h1>
        <!-- JSP para modificar valores -->
        <a href="setterJSP.jsp">Modificar valores del JavaBean</a>
        <br>
        <!-- JSP para leer valores del JavaBean -->
        <a href="getterJSP.jsp">Leer valores del JavaBean</a>
        <br>
        <br>

        <!-- JSP para recuperar parametros de un formulario-->
        <!--Formulario 1 -->
        Formulario 1:
        <br>
        <form name="form1" action="setterParamJSP.jsp">
            Base:<input type="text" name="baseParam">
            <br>
            Altura: <input type="text" name="alturaParam">
            <input type="submit" value="Enviar" >
        </form>

        <br>
        Formulario 2:
        <br>
        <form name="form2" action="setterAllParamsJSP.jsp">
            Base: <input type="text" name="base" >
            <br>
            Altura: <input type="text" name="altura" >
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
