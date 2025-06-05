package GUI;

import javax.swing.*;
import java.awt.*;
import Controladores.ControladorExpendedor;

public class panelExpendedor extends JPanel{
    private panelSeleccionProducto pSP;
    private panelInput pI;
    private panelOut pOut;

    public panelExpendedor(){
        super();
        this.setLayout(new BorderLayout());


        pSP = new panelSeleccionProducto();
        this.add(pSP,BorderLayout.CENTER);

        pI = new panelInput();
        this.add(pI,BorderLayout.EAST);

        pOut = new panelOut();
        this.add(pOut,BorderLayout.SOUTH);

    }
    public panelInput getPanelInput(){
        return pI;
    }
    public panelOut getPanelOut(){
        return pOut;
    }
    public panelSeleccionProducto getPanSelProd(){
        return pSP;
    }
}
