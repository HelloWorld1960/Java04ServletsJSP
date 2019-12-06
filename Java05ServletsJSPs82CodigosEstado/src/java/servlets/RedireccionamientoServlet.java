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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Panzer01
 */
@WebServlet(name = "RedireccionamientoServlet", urlPatterns = {"/RedireccionamientoServlet"})
public class RedireccionamientoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Ya no utilizamos el objeto printwriter para mandar la respuesta
        //Utilizamos el redireccionamiento
        String url = null;
        String tipoNavegador = request.getHeader("User-Agent");
        System.out.println("tipoNavegador" + tipoNavegador);
        if (tipoNavegador != null && tipoNavegador.contains("Trident")) {
            url = "http://www.microsoft.com";
        } else if (tipoNavegador != null && tipoNavegador.contains("Firefox")) {
            url = "http://www.firefox.com";
        } else if (tipoNavegador != null && tipoNavegador.contains("Chrome")) {
            url = "http://www.google.com";
        }

        //Redireccionamos al URL seleccionado
        response.sendRedirect(url);
    }
}
