package GUI;

import javax.swing.*;
import java.awt.*;
import org.tarea3.*;

public class panelInput extends JPanel {
    private JLabel dinero;
    private JLabel producto;
    private JLabel notificacion;
    private JButton botonDevolverMonedas;
    private JButton botonComprar;
    private JButton botonSacarMonedas;
    private JButton botonStock;
    private panelMonedasDinamico monedasAlmacenadas;
    private Wallet monedasAlmacenadasWallet;

    public panelInput(Wallet monedasAlmacenadasWallet){
        super();
        this.monedasAlmacenadasWallet = monedasAlmacenadasWallet;
        this.setLayout(new BorderLayout());
        this.setBackground(Color.black);

        Dimension size = new Dimension(200, 200);
        this.setPreferredSize(size);
        this.setMinimumSize(size);
        this.setMaximumSize(size);

        JPanel panelComponentes = new JPanel();
        panelComponentes.setOpaque(false);
        panelComponentes.setLayout(null);

        this.dinero = new JLabel("$0", JLabel.LEFT);
        this.dinero.setFont(new Font("Arial", Font.BOLD, 20));
        this.dinero.setForeground(Color.WHITE);
        this.dinero.setBounds(10,35,200,50);
        panelComponentes.add(this.dinero);

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
        this.botonDevolverMonedas.setBounds(5, 5, 190, 40);
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

        ImageIcon monedaVaciaIcon = new ImageIcon(getClass().getResource("/img/monedasVacio.png"));
        this.botonSacarMonedas = new JButton(monedaVaciaIcon);
        this.botonSacarMonedas.setBounds(115, 315, 80, 80);
        this.botonSacarMonedas.setOpaque(true);
        this.botonSacarMonedas.setContentAreaFilled(true);
        this.botonSacarMonedas.setBorderPainted(true);
        this.botonSacarMonedas.setBackground(new Color(130, 0, 0));
        this.botonSacarMonedas.setForeground(Color.WHITE);
        this.botonSacarMonedas.setFocusPainted(false);
        panelComponentes.add(this.botonSacarMonedas);

        this.botonStock = new JButton("<html><div style='text-align: center;'>AGREGAR<br>STOCK</div></html>");
        this.botonStock.setFont(new Font("Arial", Font.BOLD, 12));
        this.botonStock.setBounds(105, 165, 90, 40);
        this.botonStock.setOpaque(true);
        this.botonStock.setContentAreaFilled(true);
        this.botonStock.setBorderPainted(true);
        this.botonStock.setBackground(new Color(200, 200, 60));
        this.botonStock.setForeground(Color.BLACK);
        this.botonStock.setFocusPainted(false);
        panelComponentes.add(this.botonStock);

        add(panelComponentes, BorderLayout.CENTER);

        monedasAlmacenadas = new panelMonedasDinamico(monedasAlmacenadasWallet.getDepositoMoneda().getDeposito());
        monedasAlmacenadas.setBounds(5,165,95,278);
        panelComponentes.add(monedasAlmacenadas);
    }

    public void mostrarCambios(Object valorActualizado){
        dinero.setText("$"+(int) valorActualizado);
    }

    public void mostrarVuelto(Object objeto){
        botonSacarMonedas.setIcon(new ImageIcon(getClass().getResource("/img/monedasVacio.png")));
    }

    public void actualizarMonedasAlmacenadas() {
        monedasAlmacenadas.setMonedas(monedasAlmacenadasWallet.getDepositoMoneda().getDeposito());
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
    public JLabel getDinero(){
        return dinero;
    }
    public JButton getBotonSacarMonedas(){
        return botonSacarMonedas;
    }
    public JButton getBotonAgregarStock(){
        return botonStock;
    }
}