package org.tarea3;

/**
 * Clase abstracta Bebida que se desprende de Producto.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
abstract class Bebida extends Producto {
    private int serie;
    public Bebida(int x) {
        super(x);
    }

}
