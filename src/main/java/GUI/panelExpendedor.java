package GUI;

import javax.swing.*;
import java.awt.*;

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
}
