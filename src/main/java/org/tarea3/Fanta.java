package org.tarea3;

/**
 * Clase Fanta que se desprende de Bebida.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
public class Fanta extends Bebida {
    public Fanta(int serie) {
        super(serie);
    }
    public String consumir() {
        return "fanta";
    }
    public double getPrecio() {
        return PreciosProductos.FANTA.getPrecio();
    }
}
