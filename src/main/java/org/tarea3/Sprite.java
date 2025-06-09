package org.tarea3;

/**
 * Representa una bebida Sprite que se desprende de Bebida.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
public class Sprite extends Bebida {
    public Sprite(int serie) {
        super(serie);
    }
    public String consumir() {
        return "sprite";
    }
    public double getPrecio() {
        return PreciosProductos.SPRITE.getPrecio();
    }
    @Override
    public String toString(){
        return "sprite";
    }
}