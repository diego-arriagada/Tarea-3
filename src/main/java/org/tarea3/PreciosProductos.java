/**
 * Enumeración que guarda los precios de los productos disponibles en la máquina expendedora.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
public enum PreciosProductos {
    SNICKERS(200),
    SUPER8(100),
    SPRITE(400),
    COCA(500),
    FANTA(300);

    private final double precio;

    private PreciosProductos(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
}
