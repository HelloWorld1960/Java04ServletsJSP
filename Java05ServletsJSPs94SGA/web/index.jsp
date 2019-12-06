<%--Los servlets estan enfocados en controlar el flujo de la peticion HTTP, asi como utilizar los JavaBeans 
    para almacenar informacion y finalmente redireccionar al JSP respectivo.
    -Los JSPs estan enfocados en desplegar la informacion de la aplicacion web, en este caso la informacion es 
    proveida por medio de los servlets y la informacion que se comparte entre los Servlets y JSPs suele manejarse 
    con JavaBean. --%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Sistema Web AP</title>
    </head>
    <body>
        <div id="wrap">
            <div id="header">
                <!--Incluir el archivo header.jsp -->
                <jsp:include page="/WEB-INF/pages/commons/header.jsp"/>
            </div>

            <div id="nav">
                <!--Incluir el archivo menu.jsp -->
                <jsp:include page="/WEB-INF/pages/commons/menu.jsp"/>
            </div>

            <div id="main">
                <div class="subtitulo">
                    <!-- Utilizamos expression lenguage para acceder a la ruta, pero enviando un parametro de accion. -->
                    <a href="${pageContext.request.contextPath}/ServletControlador?accion=listarPersonas">
                        Consulta nuestro cat&aacute;logo de personas
                    </a>
                </div>
            </div>

            <div id="footer">
                <!--Incluir el archivo footer.jsp -->
                <jsp:include page="/WEB-INF/pages/commons/footer.jsp"/>
            </div>
        </div>
    </body>
</html>
