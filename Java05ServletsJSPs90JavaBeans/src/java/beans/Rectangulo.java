/*
 * Java Bean.
 */
package beans;

/**
 *
 * @author Panzer01
 */
public class Rectangulo {
    //Atributos privados.
    private int base;
    private int altura;

    //Metodos Get y Set.
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

    /**
     * Agregamos un metodo que no mapea con ninguna propiedad sino que es el
     * resultado de un calculo
     *
     * @return int valor del area
     */
    public int getArea() {
        return this.base * this.altura;
    }
}
