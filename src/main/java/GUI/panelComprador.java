package GUI;

import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;

public class panelComprador extends JPanel {
    private Image imagenFondo;
    private static final int ANCHO = 300;
    private static final int ALTO = 400;

    public panelComprador() {
        setLayout(new BorderLayout());


        try {
            imagenFondo = ImageIO.read(getClass().getResource("/img/huevorey.png"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar fondo: " + e.getMessage());
        }


        JPanel panelComponentes = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                // Hacemos este panel transparente
                g.setColor(new Color(0, 0, 0, 0));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panelComponentes.setOpaque(false);
        panelComponentes.setLayout(null);

        add(panelComponentes, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(ANCHO, ALTO);
    }
}