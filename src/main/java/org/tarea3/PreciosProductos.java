package org.tarea3;

/**
 * Enumeración que guarda los precios y el orden de los productos disponibles en la máquina expendedora.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
public enum PreciosProductos {
    COCA(500),
    SPRITE(400),
    FANTA(300),
    SNICKERS(200),
    SUPER8(100);

    private final int precio;

    PreciosProductos(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }
}
