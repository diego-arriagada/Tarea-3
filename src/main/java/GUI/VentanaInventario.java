package GUI;

import org.tarea3.Deposito;
import org.tarea3.Moneda;
import org.tarea3.Producto;
import org.tarea3.Wallet;
import org.tarea3.Moneda100;
import org.tarea3.Comprador;

import javax.swing.*;
import java.awt.*;

/**
 * VentanaInventario es una ventana que muestra el inventario de productos del comprador.
 *
 * Permite al comprador consumir productos seleccionados de su inventario.
 * Cada vez que se compra un producto en la maquina, se añade al inventario del comprador.
 * Esta ventana se abre al hacer clic en el botón "Inventario" en la interfaz del comprador.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
public class VentanaInventario extends JFrame {
    private DefaultListModel<Producto> modeloInventario;
    private Wallet wallet;

    public VentanaInventario(Ventana ventana,Comprador comp,DefaultListModel<Producto> modelo){
        this.modeloInventario = modelo;


        this.setTitle("Inventario");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(400,300);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        if (ventana != null) {
            Point pos = ventana.getLocationOnScreen();
            int x = pos.x + ventana.getWidth();
            int y = pos.y + 300;
            this.setLocation(x, y);
        }


        JList<Producto> listaProductos = new JList<>(modeloInventario);
        add(new JScrollPane(listaProductos),BorderLayout.CENTER);
        JButton botonConsumir = new JButton("CONSUMIR");
        botonConsumir.addActionListener(e -> {
            Producto p = listaProductos.getSelectedValue();
            if (p != null) {
                System.out.println("Consumiendo: " + p.consumir());
                comp.consumirProducto(p);
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona un producto primero");
            }
        });


        JPanel panelInferior = new JPanel();
        panelInferior.add(botonConsumir);
        add(panelInferior,BorderLayout.SOUTH);


        this.setVisible(false);
    }

}
