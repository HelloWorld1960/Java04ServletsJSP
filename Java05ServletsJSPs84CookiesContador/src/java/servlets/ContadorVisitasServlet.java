/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Panzer01
 */
@WebServlet(name = "ContadorVisitasServlet", urlPatterns = {"/ContadorVisitasServlet"})
public class ContadorVisitasServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Declaramos la variable contador
        int contador = 0;

        //Si existe, obtenemos el contador de visitas actual
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("contadorVisitas")) {
                    try {
                        //Obtenemos el valor del contador de visitas actual
                        contador = Integer.parseInt(c.getValue());
                    } catch (NumberFormatException e) {
                        //En caso de error, reiniciamos el contador de visitas
                        contador = 0;
                    }
                }
            }//fin del for
        }//fin del if

        //incrementamos el contador de visitas
        //y lo agregamos la cookie en la respuesta
        contador++;
        Cookie c = new Cookie("contadorVisitas", Integer.toString(contador));
        //La cookie se almacenarÃ¡ en el cliente por 1 hora (3600 seg)
        c.setMaxAge(3600);
        response.addCookie(c);

        //Mandamos el mensaje al navegador
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Contador de visitas de cada cliente: " + contador);
    }
}
