/**
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ListadoPersonas;
import model.Persona;

public class ServletControlador extends HttpServlet {

    /**Este metodo se ejecuta si la peticion se realiza a travez de GET o POST.
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Esta instrucción crea el objeto “out” que permitirá escribir la salida.
        PrintWriter out = response.getWriter();

        //Usuario para logearse en codigo duro.
        String usuario = "Jorge";
        String pass = "123";
        //Alcance SESSION.
        HttpSession sesion = request.getSession();//Obtenemos el objeto SESSION.
        //Instanciando Persona.
        Persona persona1 = new Persona("Ricardo", "Alvarado");
        Persona persona2 = new Persona("Dana", "Donato");
        Persona persona3 = new Persona("Ana", "Aponte");
        ListadoPersonas lista = new ListadoPersonas();
        lista.setPersona(persona1);
        lista.setPersona(persona2);
        lista.setPersona(persona3);
        //Agregamos el listado de personas a la sesion.
        sesion.setAttribute("lista", lista);//Asignamos una Llave-valor para acceder a el dentro del JSP.

        //Recuperamos la accion a ejecutar
        String accion = request.getParameter("accion");
        
        if ("listado".equals(accion)) {
            //Verificamos si tenemos algún usuario en sesion.
            if (sesion.getAttribute("login") == null) {
                //Si no hay usuario en sesion, ejecutamos el proceso de login.
                request.getRequestDispatcher("login.jsp").forward(request, response);//Redireccionamos al JSP seleccionado.
            } else {
                //Quiere decir que ya está un usuario en sesion.
                request.getRequestDispatcher("listado.jsp").forward(request, response);//Redireccionamos al JSP seleccionado.
            }
        } else if ("login".equals(accion)) {
            //Recuperamos el usuario proporcionado
            String usua = request.getParameter("usuarioP");
            String pss = request.getParameter("passP");

            //Verificamos que el usuario sea valido.
            if (usuario.equals(usua) && pass.equals(pss)) {
                //Solo en caso de que el usuario sea valido se agrega a la sesion, de lo contrario NO se agrega.
                sesion.setAttribute("login", usua);//Asignamos una Llave-valor para acceder a el dentro del JSP.
                request.getRequestDispatcher("listado.jsp").forward(request, response);//Redireccionamos al JSP seleccionado.
            } else {
                //Volvemos a pedir el usuario si este no es valido.
                request.getRequestDispatcher("login.jsp").forward(request, response);//Redireccionamos al JSP seleccionado.
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
