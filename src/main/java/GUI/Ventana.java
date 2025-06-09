package GUI;

import org.tarea3.Wallet;

import javax.swing.JFrame;
import java.awt.BorderLayout;


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
