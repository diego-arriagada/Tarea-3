package GUI;

import javax.swing.*;
import java.awt.*;

public class panelInput extends JPanel {
    public panelInput(){
        super();
        this.setLayout(new BorderLayout());

        JLabel titulo = new JLabel("", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(titulo,BorderLayout.NORTH);

    }
}
