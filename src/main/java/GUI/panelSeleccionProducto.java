package GUI;

import javax.swing.*;
import java.awt.*;

public class panelSeleccionProducto extends JPanel {
    public panelSeleccionProducto(){
        super();
        this.setLayout(new GridLayout(3,2));
        this.add(new JButton("coca"));
        this.add(new JButton("sprite"));
        this.add(new JButton("fanta"));
        this.add(new JButton("snickers"));
        this.add(new JButton("super8"));


    }
}
