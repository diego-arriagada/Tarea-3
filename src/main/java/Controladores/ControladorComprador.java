package Controladores;

import GUI.VentanaInventario;
import GUI.VentanaMonedero;
import GUI.panelComprador;
import org.tarea3.Comprador;
import org.tarea3.Expendedor;
import org.tarea3.Wallet;
import org.tarea3.Producto;

import javax.swing.*;

public class ControladorComprador {
    private Comprador comp;
    private panelComprador pComp;
    private DefaultListModel<Producto> modeloInventario = new DefaultListModel<Producto>();

    public ControladorComprador(Comprador comprador, panelComprador panelComp, Wallet wComp, Expendedor exp){
        this.comp = comprador;
        this.pComp = panelComp;

        pComp.getBotonInventario().addActionListener(e -> {
            VentanaInventario inventario = new VentanaInventario(comp,comp.getModeloInventario(),comp.getWallet());
            inventario.setVisible(true);
        });

        pComp.getBotonMonedero().addActionListener(e -> {
            VentanaMonedero monedero = new VentanaMonedero(comp,comp.getWallet(),comp.getModeloMonedero(),exp);
            monedero.setVisible(true);
        });
    }
    public Comprador getComprador(){
        return comp;
    }
    public DefaultListModel<Producto> getModeloInventario(){
        return modeloInventario;
    }
}
