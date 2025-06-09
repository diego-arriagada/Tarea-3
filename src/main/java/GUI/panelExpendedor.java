package GUI;

import javax.swing.*;
import java.awt.*;
import org.tarea3.Wallet;
import Controladores.ControladorExpendedor;

/**
 * panelExpendedor es un JPanel que representa la interfaz del expendedor de productos y sus botones en la Ventana principal (a la izquierda del panelComprador).
 *
 * Este panel en particular contiene tres paneles, panelSeleccionProducto, panelInput y panelOut.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
public class panelExpendedor extends JPanel{
    private panelSeleccionProducto pSP;
    private panelInput pI;
    private panelOut pOut;

    public panelExpendedor(Wallet monedasAlmacenadasWallet){
        super();
        this.setLayout(new BorderLayout());


        pSP = new panelSeleccionProducto();
        this.add(pSP,BorderLayout.CENTER);

        pI = new panelInput(monedasAlmacenadasWallet);
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
