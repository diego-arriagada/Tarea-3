package GUI;

import org.tarea3.*;

import javax.swing.*;
import java.awt.*;

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
