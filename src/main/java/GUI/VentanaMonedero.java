package GUI;

import org.tarea3.Deposito;
import org.tarea3.Moneda;
import org.tarea3.Producto;
import org.tarea3.Wallet;
import org.tarea3.Moneda100;
import org.tarea3.Comprador;

import javax.swing.*;
import java.awt.*;
import org.tarea3.Expendedor;

public class VentanaMonedero extends JFrame {
    private DefaultListModel<Moneda> modeloWallet;
    private Wallet wallet;

    public VentanaMonedero(Ventana ventana,Comprador comp,Wallet wallet,DefaultListModel<Moneda> modelo,Expendedor exp){
        this.modeloWallet = modelo;
        this.wallet = wallet;

        this.setTitle("Monedero");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(400,300);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        if (ventana != null) {
            Point pos = ventana.getLocationOnScreen();
            int x = pos.x + ventana.getWidth();
            int y = pos.y;
            this.setLocation(x, y);
        }

        JList<Moneda> listaMonedas = new JList<>(modeloWallet);
        add(new JScrollPane(listaMonedas),BorderLayout.CENTER);
        JButton botonIntroducir = new JButton("INTRODUCIR MONEDA");
        botonIntroducir.addActionListener(e -> {
            Moneda m = listaMonedas.getSelectedValue();
            if (m != null) {
                comp.getWallet().eliminarMoneda(m);   // lógica
                modeloWallet.removeElement(m);
                comp.ingresarMoneda(m,exp);

            } else {
                JOptionPane.showMessageDialog(null, "Selecciona una moneda primero");
            }
        });


        JPanel panelInferior = new JPanel();
        panelInferior.add(botonIntroducir);
        add(panelInferior,BorderLayout.SOUTH);


        this.setVisible(false);
    }


}
