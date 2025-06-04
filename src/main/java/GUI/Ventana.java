package GUI;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Ventana extends JFrame {
    public Ventana(){
        this.setTitle("Maquina Expendedora");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,600);
        setLocationRelativeTo(null);

        this.setLayout(new BorderLayout());

        panelExpendedor pE = new panelExpendedor();
        this.add(pE,BorderLayout.CENTER);

        panelComprador pC = new panelComprador();
        this.add(pC,BorderLayout.EAST);

        this.setVisible(true);

    }
}
