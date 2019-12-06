/**
 * El API de los servlets nos permite administrar las sesiones por medio de la clase httpSesion, Cada peticion realizada
 * por un cliente al recurso web genera una nueva sesion, pero las ventanas abiertas en un mismo cliente no considera 
 * como un nuevo cliente.
 * Una sesion va a permitir administrar las peticiones que realiza un usuario.
 * Las sesiones un tiempo de vida mas largo que una peticion.
 * HTTP es un protocolo sin estado, por lo que no va a recordar informacion que el usuario envio con aterioridad.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Panzer01
 */
@WebServlet(name = "SesionesServlet", urlPatterns = {"/SesionesServlet"})
public class SesionesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession sesion = request.getSession();
        String titulo = null;

        //Pedimos el atributo, y verificamos si existe
        Integer contadorVisitas = (Integer) sesion.getAttribute("contadorVisitas");

        //Si es igual a nulo, quiere decir que es la primera
        //vez que accedemos al recurso
        if (contadorVisitas == null) {
            //Esta constructor crea un nuevo objeto Integer con el especifico valor int pasado por parámetro.
            contadorVisitas = new Integer(1);
            titulo = "Bienvenido por primera vez...";
        } else {
            //si es distinto de nulo, incrementamos el contador
            titulo = "Bienvenido Nuevamente...";
            contadorVisitas += 1;
        }

        //En cualquier caso, agregamos el valor del contador
        //a la sesion
        //Los valores se almacenan en un objeto de tipo HashMap(clave, valor).
        sesion.setAttribute("contadorVisitas", contadorVisitas);

        //Mostramos los  valores en el cliente
        PrintWriter out = response.getWriter();
        out.println("T&iacute;tulo: " + titulo);
        out.println("<br>");
        out.println("No. Accesos al recurso: " + contadorVisitas);
        out.println("<br>");
        out.println("ID de la sesi&oacute;n: " + sesion.getId());
        /*Despues de 30 minutos se destruira la sesion y el ID.*/
    }
}
