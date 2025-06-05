package GUI;

import javax.swing.*;
import java.awt.*;

public class panelOut extends JPanel {
    private JLabel producto;
    private JButton botonSacar;
    public panelOut(){
        super();
        this.setLayout(new GridLayout(1,2,10,0));
        producto = new JLabel("Vacio", JLabel.CENTER);
        producto.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(producto);
    }
    public void mostrarCambios(Object productoNuevo){
        this.producto.setText(productoNuevo.toString());

    }
}
