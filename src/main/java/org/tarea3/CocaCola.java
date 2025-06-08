package org.tarea3;

/**
 * Clase CocaCola que se desprende de Bebida.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
public class CocaCola extends Bebida {
    public CocaCola(int serie) {
        super(serie);
    }
    public String consumir() {
        return "coca cola";
    }
    public double getPrecio() {
        return PreciosProductos.COCA.getPrecio();
    }

    @Override
    public String toString(){
        return "coca cola";
    }
}