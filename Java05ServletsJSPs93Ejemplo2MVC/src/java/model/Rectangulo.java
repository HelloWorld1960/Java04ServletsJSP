/**
 *
 */
package model;

/**
 *
 * @author Panzer01
 */
public class Rectangulo {
    //Atributos.
    private int base;
    private int altura;
    
    //Constructor.
    public Rectangulo() {
    }
    public Rectangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    //Metodos.
    public int getAltura() {
        return altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getBase() {
        return base;
    }
    public void setBase(int base) {
        this.base = base;
    }

    public int getArea() {
        return this.base * this.altura;
    }
}
