/**
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Rectangulo;

/**
 *
 * @author Panzer01
 */
@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {

    /**
     *
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Procesamos la peticion
        //1. Procesamos los parametros
        //Recuperamos el parametro action.
        String accion = request.getParameter("accion");

        //2. Creamos los JavaBeans a compartir
        Rectangulo recRequest = new Rectangulo(1, 2);
        Rectangulo recSession = new Rectangulo(3, 4);
        Rectangulo recApplication = new Rectangulo(5, 6);

        if ("agregaVariables".equals(accion)) {
            //3. Compartimos las variables en el alcance seleccionado:
            //Alcance request
            request.setAttribute("rectanguloRequest", recRequest); //Llave, valor
            //Alcance session
            HttpSession session = request.getSession(); //Obtenemos el objeto SESSION.
            session.setAttribute("rectanguloSession", recSession); //Asignamos una Llave-valor para acceder a el dentro del JSP.
            //Alcance application
            ServletContext application = this.getServletContext(); //Obtenemos el objeto APPLICATION.
            application.setAttribute("rectanguloApplication", recApplication); //Asignamos una Llave-valor para acceder a el dentro del JSP.
            //Agregamos un mensaje en el alcance REQUEST.
            request.setAttribute("mensaje", "Las variables fueron agregadas"); //Asignamos una Llave-valor para acceder a el dentro del JSP.

            //4. Redireccionamos al JSP seleccionado.
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else if ("listarVariables".equals(accion)) {
            //4. Unicamente redireccionamos, ya no agregamos variables y se desplegaran solamente las que sigan 
            //disponibles segun el alcance de cada variable.
            //Indicar que JSP se va a redireccionar.
            //Se propagan los objetos request y response para que puedan ser utilizados por el JSP seleccionado.
            //fordwar() sirve para enviar la informacion de request y responce al JSP.
            request.getRequestDispatcher("/WEB-INF/alcanceVariables.jsp").forward(request, response);//Redireccionamos al JSP seleccionado.

        } else {
            //4. Redireccionamos a la pagina de inicio
            //agregamos un mensaje
            request.setAttribute("mensaje", "Accion no proporcionada o desconocida"); //Asignamos una Llave-valor para acceder a el dentro del JSP.
            request.getRequestDispatcher("index.jsp").forward(request, response);//Redireccionamos al JSP seleccionado.

            //Asi que tambien se puede usar response.sendRedirect("index.jsp");, Pero esta linea no agregaria la 
            //informacion de REQUEST y RESPONSE al JSP, sino que es solo una petición al navegador Web. 
        }
    }
}
