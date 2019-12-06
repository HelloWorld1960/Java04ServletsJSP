/* Una interface es una variante de una clase abstracta con la condición de que todos sus métodos deben ser asbtractos.
 * Si la interface va a tener atributos, éstos deben llevar las palabras reservadas static final y con un valor inicial 
   ya que funcionan como constantes por lo que, por convención, su nombre va en mayúsculas. 
 * Una clase implementa una o más interfaces (separadas con comas ",") con la palabra reservada implements. 
 * Con el uso de interfaces se puede "simular" la herencia múltiple que Java no soporta. 
 * Todos los métodos de una interfaz se declaran implícitamente como abstractos y públicos.
 * La clase que implementa una interface tiene dos opciones:
    1) Implementar todos los métodos de la interface.
    2) Implementar sólo algunos de los métodos de la interface pero esa clase debe ser una 
       clase abstracta (debe declararse con la palabra abstract). */
/**Interface.
 * Contiene los metodos que debe ejecutar la clase hija UsuarioService.java.
 *  
 */
package sga.services;

import sga.eis.dto.Persona;
import java.util.List;

public interface PersonaService {
  //Metodos.
  public List<Persona> getAllPersonas();

  public Persona getPersonaById(Integer idPersona);

  public boolean eliminarPersonas(List<Integer> idPersonas);

  public boolean guardarPersona(Persona persona);

}

/**Una interfaz puede parecer similar a una clase abstracta, pero existen una serie de diferencias entre una interfaz y una 
   clase abstracta:
 * Todos los métodos de una interfaz se declaran implícitamente como abstractos y públicos.
 * Una clase abstracta no puede implementar los métodos declarados como abstractos, una interfaz no puede implementar ningún 
   método (ya que todos son abstractos).
 * Una interfaz no declara variables de instancia.
 * Una clase puede implementar varias interfaces, pero sólo puede tener una clase ascendiente directa.
 * Una clase abstracta pertenece a una jerarquía de clases mientras que una interfaz no pertenece a una jerarquía de clases. 
   En consecuencia, clases sin relación de herencia pueden implementar la misma interfaz.
 **/