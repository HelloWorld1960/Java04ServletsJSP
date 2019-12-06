/**
 * Ciclo de vida de un servlet.
 * 1) Se realiza peticion al servidor web para que se ejecute el servlet.
 * 2) El servidor web crea una instancia del servlet.
 * 3) Si es que se definio un metodo init() se manda a llamar.
 * 4) Se manda a llamar al metodo service para ejecutar el servlet.
 * 5) El servlet envia una respuesta al cliente.
 *
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Panzer01
 */
@WebServlet(name = "EjemploServlet", urlPatterns = {"/EjemploServlet"})
public class EjemploServlet extends HttpServlet {

    /**
     * Cuando el usuario coloca la url en el navegador se genera automaticamente una peticion get.
     * Para procesar esta peticion se sobreescribe el metodo doGet.
     * HttpServletRequest y HttpServletResponse los proporciona el ciclo de vida del servlet, el metodo service es
     * el responsable de ejecutar el servlet y cuando detecta que se jecuto un metodo de tipo get, manda a llamar al
     * metodo doGet y le proporciona los parametros request y response.
     * Una vez ejecutado el metodo doGet, el metodo service se encarga de enviar la respuesta hacia el cliente que
     * hizo la llamada.
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /**HttpServletRequest request tiene informacion enviada en la peticion.
          *HttpServletResponse response se permite enviar una respuesta al cliente.
         */
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Ejemplo</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Respuesta desde un servlet</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

}
