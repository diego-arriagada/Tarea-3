package Controladores;

import GUI.panelExpendedor;
import org.tarea3.Expendedor;
import org.tarea3.NoHayProductoException;
import org.tarea3.PagoIncorrectoException;
import org.tarea3.PagoInsuficienteException;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ControladorExpendedor {
    private Expendedor exp;
    private panelExpendedor panelExp;

    public ControladorExpendedor(Expendedor expend, panelExpendedor panelExpend) {
        this.exp = expend;
        this.panelExp = panelExpend;

        exp.addPropertyChangeListener(evt -> {
            switch (evt.getPropertyName()) {
                case "Valor Monedas":
                    panelExp.getPanelInput().mostrarCambios(evt.getNewValue());
                    break;
                case "Producto en Deposito":
                    panelExp.getPanelOut().mostrarCambios(evt.getNewValue());
            }
        });
        panelExp.getPanSelProd().getBotonCoca().addActionListener(e -> {
            exp.setProductoSeleccionado(0);
            panelExp.getPanelInput().getProducto().setText("COCA COLA");
            System.out.println(exp.getProductoSeleccionado());
        });
        panelExp.getPanSelProd().getBotonSprite().addActionListener(e -> {
            exp.setProductoSeleccionado(1);
            panelExp.getPanelInput().getProducto().setText("SPRITE");
            System.out.println(exp.getProductoSeleccionado());
        });
        panelExp.getPanSelProd().getBotonFanta().addActionListener(e -> {
            exp.setProductoSeleccionado(2);
            panelExp.getPanelInput().getProducto().setText("FANTA");
            System.out.println(exp.getProductoSeleccionado());
        });
        panelExp.getPanSelProd().getBotonSnickers().addActionListener(e -> {
            exp.setProductoSeleccionado(3);
            panelExp.getPanelInput().getProducto().setText("SNICKERS");
            System.out.println(exp.getProductoSeleccionado());
        });
        panelExp.getPanSelProd().getBotonSuper8().addActionListener(e -> {
            exp.setProductoSeleccionado(4);
            panelExp.getPanelInput().getProducto().setText("SUPER 8");
            System.out.println(exp.getProductoSeleccionado());
        });
        panelExp.getPanelInput().getBotonComprar().addActionListener(e -> {
            try{
                exp.compraDeProducto();
            }catch (Exception ex){
                if (ex instanceof NoHayProductoException){
                    System.out.println("nohay");
                }
                else if (ex instanceof PagoIncorrectoException){
                    System.out.println("Pago malo");
                }
                else if (ex instanceof PagoInsuficienteException){
                    System.out.println("nohayplata");
                }
            }
        });


    }
}