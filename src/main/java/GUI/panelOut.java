package GUI;

import org.tarea3.*;

import javax.swing.*;
import java.awt.*;

/**
 * panelOut es un JPanel dentro de panelExpendedor que se encuentra debajo de panelInput y panelSeleccionProducto.
 *
 * Este panel muestra el producto comprado por el usuario, representado por un botón que cambia su icono según el producto adquirido.
 * Pictoricamente, representa al deposito donde caen los productos comprados por el usuario.
 * La imagen del producto en si es un boton que permite extraer el producto comprado y añadirlo al inventario del comprador.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
public class panelOut extends JPanel {
    private JButton producto;
    private JButton botonSacar;
    public panelOut(){
        super();
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(0,0,0,220));
        ImageIcon productoIcon = new ImageIcon(getClass().getResource("/img/vacio.png"));
        this.producto = new JButton(productoIcon);
        producto.setPreferredSize(new Dimension(120,80));
        this.add(producto,BorderLayout.WEST);
    }
    public void mostrarCambios(Object productoNuevo){
        if(productoNuevo instanceof CocaCola){
            producto.setIcon(new ImageIcon(getClass().getResource("/img/cocaComprada.png")));
        }else if(productoNuevo instanceof Sprite){
            producto.setIcon(new ImageIcon(getClass().getResource("/img/spriteComprada.png")));
        }else if(productoNuevo instanceof Fanta){
            producto.setIcon(new ImageIcon(getClass().getResource("/img/fantaComprada.png")));
        }else if (productoNuevo instanceof Snickers){
            producto.setIcon(new ImageIcon(getClass().getResource("/img/snickersComprado.png")));
        }else if (productoNuevo instanceof Super8){
            producto.setIcon(new ImageIcon(getClass().getResource("/img/super8Comprada.png")));
        }else if (productoNuevo == null){
            producto.setIcon(new ImageIcon(getClass().getResource("/img/vacio.png")));
        }

    }
    public JButton getProductoComprado(){
        return producto;
    }
}
