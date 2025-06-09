package GUI;

import org.tarea3.Wallet;

import javax.swing.JFrame;
import java.awt.BorderLayout;

/**
 * Ventana es una clase que representa la ventana principal de la aplicación de la máquina expendedora.
 *
 * Contiene dos paneles: uno para el expendedor y otro para el comprador, cada uno con sus respectivos botones y funcionalidades.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
public class Ventana extends JFrame {
    private panelExpendedor pE;
    private panelComprador pC;
    public Ventana(Wallet monedasAlmacenadasWallet){
        this.setTitle("Maquina Expendedora");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,600);
        setLocationRelativeTo(null);

        this.setLayout(new BorderLayout());

        this.pE = new panelExpendedor(monedasAlmacenadasWallet);
        this.add(pE,BorderLayout.CENTER);

        this.pC = new panelComprador();
        this.add(pC,BorderLayout.EAST);
        pack();

        this.setVisible(true);
        setResizable(false);

    }

    public panelExpendedor getpE(){
        return pE;
    }
    public panelComprador getpC(){
        return pC;
    }
}
