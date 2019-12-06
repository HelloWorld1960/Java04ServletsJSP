<%-- 
    Document   : index
    Created on : May 10, 2019, 4:12:00 PM
    Author     : Panzer01

    -Declaraciones:
    Sintaxis: <%! codigo Java %>
    Se utiliza para agregar codigo a la clase del Servlet generado.
    El codigo declarado, por ejemplo si se declara una variable, se vuelve una variable de instancia de la clase del 
    Servlet generado. Los metodos declarados tambien se vuelven parte la clase del Servlet generado.
--%>
<%-- Agregamos una declaracion --%>
<%!
    //Declaramos una variable con su metodo get
    private String usuario = "Panzer01";

    public String getUsuario() {
        return this.usuario;
    }

    //Declaramos un contador de visitas
    private int contadorVisitas = 1;
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uso de Declaraciones</title>
    </head>
    <body>
        <h1>Uso de Declaraciones</h1>
        Usuario por medio del atributo: <%= this.usuario%>
        <br>
        Usuario por medio del metodo: <%= this.getUsuario()%>
        <br>

        Contador de Visitas desde que se reinicio el servidor:
        <%= this.contadorVisitas++%>
    </body>
</html>
