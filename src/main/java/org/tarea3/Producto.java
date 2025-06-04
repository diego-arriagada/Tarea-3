package org.tarea3;

/**
 * Clase abstracta Producto, que forma la base de la jerarquía de productos.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
abstract class Producto {
    private int serie;
    public Producto(int x){
        this.serie = x;
    }
    public int getSerie() {
        return serie;
    }
    public abstract double getPrecio();

    public abstract String consumir();
}
