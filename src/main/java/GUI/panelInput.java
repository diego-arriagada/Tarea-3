package GUI;

import javax.swing.*;
import java.awt.*;

public class panelInput extends JPanel {
    private JLabel dinero;
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

        dinero = new JLabel("$0", JLabel.CENTER);
        dinero.setFont(new Font("Arial", Font.BOLD, 20));
        dinero.setForeground(Color.WHITE);
        dinero.setBounds(10,35,50,50);
        panelComponentes.add(dinero);

        JLabel productoSeleccionado = new JLabel("PRODUCTO SELECCIONADO: ",JLabel.CENTER);
        productoSeleccionado.setFont(new Font("Arial", Font.BOLD, 10));
        productoSeleccionado.setForeground(Color.WHITE);
        productoSeleccionado.setBounds(0,60,150,50);
        panelComponentes.add(productoSeleccionado);

        JLabel producto = new JLabel("COCA COLA",JLabel.LEFT);
        producto.setFont(new Font("Arial", Font.BOLD, 20));
        producto.setForeground(Color.WHITE);
        producto.setBounds(5,70,150,70);
        panelComponentes.add(producto);

        JButton botonDevolverMonedas = new JButton("SACAR VUELTO");
        botonDevolverMonedas.setBounds(5, 5, 190, 40); // Posición (x,y) y tamaño (ancho,alto)


        botonDevolverMonedas.setOpaque(true);
        botonDevolverMonedas.setContentAreaFilled(true);
        botonDevolverMonedas.setBorderPainted(true);
        botonDevolverMonedas.setBackground(new Color(130, 0, 0));
        botonDevolverMonedas.setForeground(Color.WHITE);
        botonDevolverMonedas.setFocusPainted(false);

        panelComponentes.add(botonDevolverMonedas);


        JButton botonComprar = new JButton("COMPRAR");
        botonComprar.setBounds(5, 120, 150, 25);

        botonComprar.setOpaque(true);
        botonComprar.setContentAreaFilled(true);
        botonComprar.setBorderPainted(true);
        botonComprar.setBackground(new Color(0, 130, 0));
        botonComprar.setForeground(Color.WHITE);
        botonComprar.setFocusPainted(false);

        panelComponentes.add(botonComprar);

        add(panelComponentes, BorderLayout.CENTER);
    }
    public void mostrarCambios(Object valorActualizado){
        dinero.setText("$"+(int) valorActualizado);
    }
}
