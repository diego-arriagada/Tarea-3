package GUI;

import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;

public class panelComprador extends JPanel {
    private Image imagenFondo;
    private static final int ANCHO = 300;
    private static final int ALTO = 400;

    public panelComprador() {
        setLayout(new BorderLayout()); // Usamos BorderLayout para mejor organización

        // Cargar imagen de fondo
        try {
            imagenFondo = ImageIO.read(getClass().getResource("/img/huevorey.png"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar fondo: " + e.getMessage());
        }

        // Configurar panel intermedio transparente para los componentes
        JPanel panelComponentes = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                // Hacemos este panel transparente
                g.setColor(new Color(0, 0, 0, 0));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panelComponentes.setOpaque(false);
        panelComponentes.setLayout(null); // Layout absoluto para posicionamiento manual

        // Crear y añadir botón
        JButton boton = new JButton("Comprar");
        boton.setBounds(200, 300, 100, 40); // Posición (x,y) y tamaño (ancho,alto)

        // Hacer el botón semi-transparente
        boton.setOpaque(false);
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(true);
        boton.setForeground(Color.BLACK);

        panelComponentes.add(boton);
        add(panelComponentes, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar fondo escalado
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(ANCHO, ALTO);
    }
}