<%-- 
    Document   : reporteExcel
    Created on : May 10, 2019, 6:20:45 PM
    Author     : Panzer01

    Las directivas nos permiten controlar el comportamiento de los JSPs.
    Tambien se puede especificar :
    Las clases Jva que queremos importar en un JSP.
    El tipo MIME utilizado.
    Indicar si el JSP puede acceder a la sesion HTTP.
    EL tamaño del buffer de salida.
    Indicar la pagina JSP en caso de alguna Excepcion.
    EL manejo de multihilos.

    Atributo import: <%@ page import="paquete.Clase1, paquete.ClaseN" %>
    Atributo contentType: <%@ page contentType="MIME-Type" %>
    Atributo Session: <%@ page session="true" %>
    Atributo isELignored <%@ page isELignored="false" %>
    Atributo buffer <%@ page buffer="tamañoEnKb" %>
    Atributo errorPage <%@ page errorPage="url relativo al JSP de error" %>
    Atributo isErrorPage <%@ page isErrorPage="true" %>
    Atributo isThreadSafe <%@ page isThreadSafe="true" %>
    Atributo extends <%@ extends extends="paquete.NombreClase" %>
--%>
<%-- Utilizando la directiva de import --%>
<%@page import="utilerias.Conversiones, java.util.Date" %>
<%-- Indicamos que se va a responder con un archivo de tipo excel --%>
<%@page contentType="application/vnd.ms-excel" %>

<%
  String nombreArchivo="reporte.xls";
  response.setHeader("Content-Disposition", "inline; filename=" + nombreArchivo );
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte de Excel</title>
    </head>
    <body>
        <h1>Reporte de Excel</h1>
        <br>
        <table border="1">
          <tr>
            <th>Curso</th>
            <th>Descripcion</th>
            <th>Fecha Inicio</th>
          </tr>
          <tr>
            <td>1. Fudamentos de Java</td>
            <td>Aprenderemos la sintaxis basica de Java</td>
            <td><%= Conversiones.formato(new Date()) %></td>
          </tr>
          <tr>
            <td>2. Programacion con Java</td>
            <td>Pondremos en practica conceptos de
              la Programacion Orientada a Objetos
            </td>
            <td><%= Conversiones.formato(new Date()) %></td>
          </tr>
        </table>
    </body>
</html>
