/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

public class Persona {
    //Atributos.
    private String nombre;
    private String apellido;

    //Constructor.
    public Persona() {
    }
    //Constructor sobrecargado.
    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    //Metodos.
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
