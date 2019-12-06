/**
 * El protocolo http no guarda estados del cliente, por lo tanto los elementos enviados utlizan el objeto httpSession 
 * para recordar los datos enviados por cada peticion.
 * Por cada cliente que realice una peticion se le creara un objeto de tipo httpSession.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "CarritoServlet", urlPatterns = {"/CarritoServlet"})
public class CarritoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); //Especificar el tipode respuesta.

        //Procesamos el nuevo articulo
        String articuloNuevo = request.getParameter("articulo");

        //Creamos o recuperamos la sesion http
        HttpSession sesion = request.getSession();

        //Recuperamos la lista de articulos previos
        //si es que existen en la sesion
        //Los elementos de tipo session son como un MAP(clave, valor)
        List<String> articulos = (List<String>) sesion.getAttribute("articulos");

        //Verificamos si la lista de articulos existe
        if (articulos == null) {
            //si no existen, inicializamos la lista
            //y la agregamos a la sesion
            articulos = new ArrayList<>();
            sesion.setAttribute("articulos", articulos);
        }

        //Ya tenemos la lista de articulos lista para trabajar
        //Agregamos el nuevo articulo
        //y lo agregamos por paso por referencia a la lista de
        //articulos
        //La funcion trim quita espacios a la derecha y a la izquierda, ya que desde el formulario pueden
        //enviarse espacios por error.
        if (articuloNuevo != null && !articuloNuevo.trim().equals("")) {
            articulos.add(articuloNuevo);
        }
        try (PrintWriter out = response.getWriter()) {
            //Mostramos los articulos totales al cliente
            out.println("<h1>Lista de Art&iacute;culos</h1>");
            out.println("<br>");

            //Iteramos todos los articulos, incluyendo el nuevo
            for (String articulo : articulos) {
                out.print("<LI>" + articulo + "</LI>");
            }

            //Agregamos un link para regresar al inicio
            out.println("<br>");
            out.println("<a href='/Java05ServletsJSPs85CarritoCompras'>regresar</a>");
            out.close();
        }
    }
}
