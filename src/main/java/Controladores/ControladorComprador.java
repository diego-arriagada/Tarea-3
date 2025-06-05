package Controladores;

import GUI.panelComprador;
import org.tarea3.Comprador;
import org.tarea3.Wallet;

public class ControladorComprador {
    private Comprador comp;
    private panelComprador pComp;

    public void ControladorExpendedor(Comprador comprador, panelComprador panelComp, Wallet wComp){
        this.comp = new Comprador(wComp);
        this.pComp = new panelComprador();


    }
}
