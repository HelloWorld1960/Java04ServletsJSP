<%-- 
    Document   : index
    Created on : May 17, 2019, 8:21:33 PM
    Author     : Panzer01
    Expression Lenguage con JSP.
    Permite simplificar el despliegue de informacion en un JSP utilizando JavaBeans.
    Lo que en realidad hace es llamar indirectamente al metodo GET asociado al nombre de la propiedad.
    Sintaxis: 
            ${ alcance.nombreBean.nombrePropiedad }
            ${ alcance.nombreBean["nombrePropiedad"]}
    Se debe especificar el alcance(scope) que tiene la variable, en caso de no proporcionar el dato se intuye que el 
    alcance es pageScope, de lo contrario buscara entre requestScope, sessionScope y applicationScope hasta dar con su 
    alcance.

    Caracteristicas de Expression Lenguage:
    -Los objetos JavaBean a utilizar se deben agregar previamente en algun alcance(scope) por medio del metodo 
    setAttribute() en un Servlet. (page, request, session y application)
    -Solo permite la lectura de informacion (GETTERS). No existe notacion para la modificacion de los atributos en un 
    JavaBeans(SETTERS) esa tarea es propia de los servlets.
    -Permite acceder  propiedades de un JavaBean de manera anidada.
    Ej. ${alumno.direccion.calle}

    Esta es una manera muy simple de acceder a la informacion que nos comparten los Servlets y desde los JSPs utilizar 
    Expression Lenguage para acceder a los Beans compartidos desde un Servlet.

    -Acceso a propiedades de un objeto de tipo Collection o Arreglos.
    Sintaxis: ${listaPersonas[indice/llave]}
    -Converciones automaticas de tipos de datos al desplegar la informacion.

    Acceso a variables implicitas con Expression Lenguaje.
    -Acceder al Objeto pageContext: Podemos acceder al objeto session.
    Sintaxis: ${$ pageContext.session.id}
    -Acceder a valores con param y paramValues.
    Sintaxis: ${$ param.nombre}
    -Valores de cabeceros con header y headerValues.
    Sintaxis: ${cookie.nombreCookie.value}
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo Expression Language</title>
    </head>
    <body>
        <h1>Ejemplo de Expression Language</h1>
        <br>
        <!-- Ese enlace contiene un parametro el cual se enviara a el jsp como parametro. -->
        <a href="variablesImplicitas.jsp?usuario=panzer01">Objetos impl&iacute;citos con EL(Expression Language)</a>
        <br>
        <br>

        <!--Entramos al JSP que accede al JavaBean -->
        Formulario HTML:
        <br>
        <form name="form1" action="accesoJavaBeans.jsp">
            Base:<input type="text" name="base" />
            <br>
            Altura:<input type="text" name="altura" />
            <input type="submit" value="Enviar" />
        </form>

    </body>
</html>
