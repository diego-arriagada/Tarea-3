package GUI;

import javax.swing.*;
import java.awt.*;

public class panelInput extends JPanel {
    private JLabel titulo;
    public panelInput(){
        super();
        this.setLayout(new BorderLayout());

        titulo = new JLabel("$0", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(titulo,BorderLayout.NORTH);

    }
    public void mostrarCambios(Object valorActualizado){
        titulo.setText("$"+(int) valorActualizado);
    }
}
