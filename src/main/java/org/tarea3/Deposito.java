package org.tarea3;

import java.util.ArrayList;

/**
 * Clase Deposito que define las funciones de un deposito generico para el resto del codigo.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
public class Deposito<T> {
    ArrayList<T> deposito;
    public Deposito() {
        deposito = new ArrayList<T>();
    }
    public void addObjeto(T m) {
        if (m != null) {
            deposito.add(m);
        }
    }
    public T getObjeto(){
        if (deposito.size() > 0) {
            return (T)deposito.remove(0);
        }
        return null;
    }
    public void eliminarObjeto(T m){
        deposito.remove(m);
    }
    public ArrayList<T> getDeposito(){
        return deposito;
    }
}
