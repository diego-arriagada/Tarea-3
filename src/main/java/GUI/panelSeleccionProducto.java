package GUI;

import javax.swing.*;
import java.awt.*;

public class panelSeleccionProducto extends JPanel {
    public panelSeleccionProducto(){
        super();
        this.setLayout(new GridLayout(3,2,10,10));
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.setBackground(Color.DARK_GRAY);

        ImageIcon cocaIcon = new ImageIcon(getClass().getResource("/img/coca.png"));
        JButton cocaBoton = new JButton(cocaIcon);
        cocaBoton.setPreferredSize(new Dimension(80,120));
        this.add(cocaBoton);
        ImageIcon spriteIcon = new ImageIcon(getClass().getResource("/img/sprite.png"));
        JButton spriteBoton = new JButton(spriteIcon);
        spriteBoton.setPreferredSize(new Dimension(80,120));
        this.add(spriteBoton);
        ImageIcon fantaIcon = new ImageIcon(getClass().getResource("/img/fanta.png"));
        JButton fantaBoton = new JButton(fantaIcon);
        fantaBoton.setPreferredSize(new Dimension(80,120));
        this.add(fantaBoton);
        ImageIcon snickersIcon = new ImageIcon(getClass().getResource("/img/snickers.png"));
        JButton snickersBoton = new JButton(snickersIcon);
        snickersBoton.setPreferredSize(new Dimension(80,120));
        this.add(snickersBoton);
        ImageIcon super8Icon = new ImageIcon(getClass().getResource("/img/super8.png"));
        JButton super8Boton = new JButton(super8Icon);
        super8Boton.setPreferredSize(new Dimension(80,120));
        this.add(super8Boton);

    }
}
