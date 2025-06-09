package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import org.tarea3.Moneda;
import org.tarea3.Moneda1000;
import org.tarea3.Moneda500;
import org.tarea3.Moneda100;

/**
 * El panelMonedasDinamico es un JPanel dentro de panelInput que a su vez es parte de panelExpendedor.
 *
 * Este panel se actualiza cada vez que se agregue una nueva moneda al monedero del comprador.
 * Las monedas dentro no salen jamás del panel, y solo representan las monedas que han sido ingresadas desde que se inició la aplicación.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
public class panelMonedasDinamico extends JPanel {
    private List<Moneda> monedas;

    public panelMonedasDinamico(List<Moneda> monedas) {
        this.monedas = monedas;
        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(80, 40));
    }

    public void setMonedas(List<Moneda> monedas) {
        this.monedas = monedas;
        repaint();
    }


    //Esta parte fue realizada con copilot, pues se necesitaba un calculo matematico un poco extenso
    //calcula manualmente las relaciones en pantalla entre filas,columnas,ancho,alto cantidad de imagenes para
    //recalcular cada vez que se agregue un nuevo elemento en pantalla
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (monedas == null || monedas.isEmpty()) return;

        int cols = 2; // Número fijo de columnas
        int n = monedas.size();
        int rows = (int) Math.ceil((double) n / cols);

        int panelW = getWidth();
        int panelH = getHeight();

        int margenHorizontal = 2;
        int margenVertical = 2;

        int totalMargenHorizontal = margenHorizontal * (cols + 1);
        int totalMargenVertical = margenVertical * (rows + 1);

        int cellW = Math.max(1, (panelW - totalMargenHorizontal) / cols);
        int cellH = Math.max(1, (panelH - totalMargenVertical) / rows);

        for (int i = 0; i < n; i++) {
            Moneda m = monedas.get(i);
            ImageIcon icon = getIconFor(m);
            if (icon == null) continue;

            int iconW = icon.getIconWidth();
            int iconH = icon.getIconHeight();

            double escala = Math.min((double) cellW / iconW, (double) cellH / iconH);
            int drawW = (int) (iconW * escala);
            int drawH = (int) (iconH * escala);

            int col = i % cols;
            int row = i / cols;

            int x = margenHorizontal + col * (cellW + margenHorizontal);
            int y = margenVertical + row * (cellH + margenVertical);

            x += Math.max(0, (cellW - drawW) / 2);
            y += Math.max(0, (cellH - drawH) / 2);

            g.drawImage(icon.getImage(), x, y, drawW, drawH, this);
        }
    }

    private ImageIcon getIconFor(Moneda m) {
        if (m instanceof Moneda1000) {
            return new ImageIcon(getClass().getResource("/img/moneda1000.png"));
        } else if (m instanceof Moneda500) {
            return new ImageIcon(getClass().getResource("/img/moneda500.png"));
        } else if (m instanceof Moneda100) {
            return new ImageIcon(getClass().getResource("/img/moneda100.png"));
        }
        return null;
    }
}