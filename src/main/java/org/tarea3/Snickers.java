package org.tarea3;

/**
 * Clase Snickers que se desprende de Dulce.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
public class Snickers extends Dulce {
    public Snickers(int x){
        super(x);
    }
    public String consumir(){
        return "snickers";
    }
    public double getPrecio() {
        return PreciosProductos.SNICKERS.getPrecio();
    }
    @Override
    public String toString(){
        return "snickers";
    }
}
