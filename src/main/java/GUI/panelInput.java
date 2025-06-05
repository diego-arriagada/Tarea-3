package GUI;

import javax.swing.*;
import java.awt.*;

public class panelInput extends JPanel {
    private JLabel dinero;
    private JLabel producto;
    private JLabel notificacion;
    private JButton botonDevolverMonedas;
    private JButton botonComprar;
    public panelInput(){
        super();
        this.setLayout(new BorderLayout());

        this.setBackground(Color.black);

        Dimension size = new Dimension(200, 150);
        this.setPreferredSize(size);
        this.setMinimumSize(size);
        this.setMaximumSize(size);

        JPanel panelComponentes = new JPanel(){

        };
        panelComponentes.setOpaque(false);
        panelComponentes.setLayout(null);

        dinero = new JLabel("$0", JLabel.LEFT);
        dinero.setFont(new Font("Arial", Font.BOLD, 20));
        dinero.setForeground(Color.WHITE);
        dinero.setBounds(10,35,200,50);
        panelComponentes.add(dinero);

        JLabel productoSeleccionado = new JLabel("PRODUCTO SELECCIONADO: ",JLabel.CENTER);
        productoSeleccionado.setFont(new Font("Arial", Font.BOLD, 10));
        productoSeleccionado.setForeground(Color.WHITE);
        productoSeleccionado.setBounds(0,60,150,50);
        panelComponentes.add(productoSeleccionado);

        this.notificacion = new JLabel("Esperando compra...", JLabel.LEFT);
        this.notificacion.setFont(new Font("Arial", Font.BOLD, 10));
        this.notificacion.setForeground(Color.WHITE);
        this.notificacion.setBounds(5,120,200,70);
        panelComponentes.add(this.notificacion);


        this.producto = new JLabel("No hay producto seleccionado",JLabel.LEFT);
        this.producto.setFont(new Font("Arial", Font.BOLD, 12));
        this.producto.setForeground(Color.WHITE);
        this.producto.setBounds(5,70,200,70);
        panelComponentes.add(this.producto);

        this.botonDevolverMonedas = new JButton("SACAR VUELTO");
        this.botonDevolverMonedas.setBounds(5, 5, 190, 40); // Posición (x,y) y tamaño (ancho,alto)


        this.botonDevolverMonedas.setOpaque(true);
        this.botonDevolverMonedas.setContentAreaFilled(true);
        this.botonDevolverMonedas.setBorderPainted(true);
        this.botonDevolverMonedas.setBackground(new Color(130, 0, 0));
        this.botonDevolverMonedas.setForeground(Color.WHITE);
        this.botonDevolverMonedas.setFocusPainted(false);

        panelComponentes.add(this.botonDevolverMonedas);


        this.botonComprar = new JButton("COMPRAR");
        this.botonComprar.setBounds(5, 120, 150, 25);

        this.botonComprar.setOpaque(true);
        this.botonComprar.setContentAreaFilled(true);
        this.botonComprar.setBorderPainted(true);
        this.botonComprar.setBackground(new Color(0, 130, 0));
        this.botonComprar.setForeground(Color.WHITE);
        this.botonComprar.setFocusPainted(false);

        panelComponentes.add(this.botonComprar);

        add(panelComponentes, BorderLayout.CENTER);
    }
    public void mostrarCambios(Object valorActualizado){
        dinero.setText("$"+(int) valorActualizado);
    }
    public JButton getBotonComprar(){
        return this.botonComprar;
    }
    public JButton getBotonDevolverMonedas(){
        return this.botonDevolverMonedas;
    }
    public JLabel getProducto(){
        return producto;
    }
    public JLabel getNotificacion(){
        return notificacion;
    }
}
