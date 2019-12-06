/**
 * Un servlet es una clase de java que permite procesar peticiones web por medio del protocolo http, 
 * cuando el cliente hace una peticion al servidor web, por medio de un servlet se va a poder procesar dicha 
 * peticion.
 * En la peticion pueden hir parametros como resultado de ejecutar un link o informacion que provenga de un formulario 
 * html, despues el servlet procesa la informacion recibida, realiza una respuesta al cliente que realizo la peticion.
 * El uso mas comun de un servlet es para controlar el flujo de una aplicacion web, por ejemplo en MVC juega el papel del 
 * controlador.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Panzer01
 */
//Configuracion del servlet.
@WebServlet(name = "HolaMundo", urlPatterns = {"/HolaMundo"})
/**
 * Se hace un extends de HttpServlet para que el servidor de aplicaciones
 * reconosca esta clase como una clase valida de tipo servlet.
 */
public class HolaMundo extends HttpServlet {

    /**
     * metodo GET envia informacion a travez de la url del navegador web hacia el servidor servlet con java.
     * Este metodo recibe la peticion que realiza el usuario desde el navegador web a el servidor java, una vez 
     * recibida la peticion, el servidor(clase servlet) va a responder con un documento html y va a generar 
     * este contenido html.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HolaMundo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HolaMundo, la aplicacion se llama: " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
