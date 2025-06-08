package org.tarea3;

/**
 * Clase Super8 que se desprende de Dulce.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
public class Super8 extends Dulce {
    private int serie;
    public Super8(int x){
        super(x);
    }
    public String consumir(){
        return "super8";
    }
    public double getPrecio() {
        return PreciosProductos.SUPER8.getPrecio();
    }
    @Override
    public String toString(){
        return "super8";
    }
}
