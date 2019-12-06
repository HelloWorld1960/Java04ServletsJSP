/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para generar un JavaBean de la lista de rectangulos
 * y que se pueda usar con jsp:useBean desde un JSP.
 * @author Panzer01
 */
public class ListaRectangulos {
  //Atributo que almacenará los objetos rectangulos
  private List<Rectangulo> lista = new ArrayList<>();

  /**
   * Este método nos permite simular una propuedad llamada
   * "rectangulo" desde la accion jsp:setProperty en un JSP
   * Este metodo recibe un objeto de tipo Rectangulo y lo agrega a la lista.
   * @param r
   */
  public void setRectangulo(Rectangulo r){
    this.lista.add( r );
  }

  /**
   * Este metodo retorna la lista de objetos de tipo Rectangulo.
   */
  public List<Rectangulo> getLista() {
    return (lista);
  }

  /**
   * Este metodo Modifica el objeto lista, aunque no se ocupa en este programa, se debe definir su metodo por tartarse 
   * de un JavaBean.
   */
  public void setLista(List<Rectangulo> lista) {
    this.lista = lista;
  }

}
