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
        // Agregar moneda al deposito de vuelto
        if (m != null) {
            deposito.add(m);
        }
    }
    public T getObjeto(){
        // Retornar una moneda del deposito de vuelto
        if (deposito.size() > 0) {
            return (T)deposito.remove(0);
        }
        return null;
    }
    public ArrayList<T> getDeposito(){
        return deposito;
    }
}
