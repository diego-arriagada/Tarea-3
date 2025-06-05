package Controladores;

import GUI.panelExpendedor;
import org.tarea3.Expendedor;
import javax.swing.*;

public class ControladorExpendedor {
    private Expendedor exp;
    private panelExpendedor panelExp;

    public ControladorExpendedor(Expendedor expend, panelExpendedor panelExpend){
        this.exp = expend;
        this.panelExp = panelExpend;

    exp.addPropertyChangeListener(evt -> {
        switch (evt.getPropertyName()){
            case "Valor Monedas":
                panelExp.getPanelInput().mostrarCambios(evt.getNewValue());
                break;
            case "Producto en Deposito":
                panelExp.getPanelOut().mostrarCambios(evt.getNewValue());
        }
        });
    }

}
