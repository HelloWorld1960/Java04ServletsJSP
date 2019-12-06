/* CONTROLADOR:
   Este servlet se encarga de agregar la informacion que el desplegarVariables.jsp va a utilizar, es decir va a
   compartir informacion por ejemplo en el alcance request y una vez que el servlet ha compartido la informacion y 
   redirecciona el flujo al jsp, entonces el jsp puede acceder a los objetos que se han compartido en cierto alcance.
 */
package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. Procesamos y validamos los parametros.
        //En este caso no hay necesidad de procesar parametros
        
        //2. Realizamos la logica de presentacion almacenando el resultado en JavaBeans.
        //Creamos los JavaBeans
        //La clase rectangulo actuara como el modelo.
        Rectangulo rec = new Rectangulo(3, 6);

        //3. Agregamos las variables en cierto alcance.
        //Compartir en el alcanse request.
        request.setAttribute("mensaje", "Saludos desde el servlet"); //key, valor
        //Compartir  el objeto Bean Rectangulo en el alcanse session.
        HttpSession session = request.getSession();
        session.setAttribute("rectangulo", rec); //key, valor

        //4. Redireccionamos al JSP.
        //Indicar que JSP se va a redireccionar.
        RequestDispatcher rd = request.getRequestDispatcher("vista/desplegarVariables.jsp");
        //Se propagan los objetos request y response
        //para que puedan ser utilizados por el JSP seleccionado
        //fordwar sirve para enviar la informacion de request y responce al JSP.
        rd.forward(request, response);

        //Ya no se necesita hacer nada mas despues del
        //redireccionamiento, ya que el flujo continua
        //con el JSP
    }

}
