/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import java.util.List;

public class ListadoPersonas {
    //Atributos.
    List<Persona> lista = new ArrayList<Persona>();

    //Metodos.
    public void setPersona(Persona p){
        this.lista.add(p);
    }

    public List<Persona> getLista() {
        return lista;
    }
    public void setLista(List<Persona> lista) {
        this.lista = lista;
    }



}
