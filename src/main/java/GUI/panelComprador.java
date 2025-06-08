package GUI;

import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;

public class panelComprador extends JPanel {
    private Image imagenFondo;
    private JPanel panelComponentes;
    private JButton botonInventario;
    private JButton botonMonedero;
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
                g.setColor(new Color(0, 0, 0, 0));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panelComponentes.setOpaque(false);
        panelComponentes.setLayout(null);
        panelComponentes.setPreferredSize(new Dimension(300, 150));

        this.botonInventario = new JButton();
        this.botonInventario.setBounds(0, 30, 105, 120); // Posición (x,y) y tamaño (ancho,alto)
        this.botonInventario.setOpaque(false);
        this.botonInventario.setContentAreaFilled(true);
        this.botonInventario.setBorderPainted(true);
        this.botonInventario.setBackground(new Color(0, 0, 0,0));
        this.botonInventario.setForeground(Color.WHITE);
        this.botonInventario.setFocusPainted(false);
        panelComponentes.add(this.botonInventario);

        this.botonMonedero = new JButton();
        this.botonMonedero.setBounds(204, 30, 96, 120); // Posición (x,y) y tamaño (ancho,alto)
        this.botonMonedero.setOpaque(false);
        this.botonMonedero.setContentAreaFilled(true);
        this.botonMonedero.setBorderPainted(true);
        this.botonMonedero.setBackground(new Color(0, 0, 0,0));
        this.botonMonedero.setForeground(Color.WHITE);
        this.botonMonedero.setFocusPainted(false);
        panelComponentes.add(this.botonMonedero);

        add(panelComponentes, BorderLayout.SOUTH);
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

    public JPanel getPanelComponentes(){
        return panelComponentes;
    }
    public JButton getBotonInventario(){
        return botonInventario;
    }
    public JButton getBotonMonedero(){
        return botonMonedero;
    }
}