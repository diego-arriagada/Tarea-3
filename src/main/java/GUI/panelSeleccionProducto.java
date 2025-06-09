package GUI;

import javax.swing.*;
import java.awt.*;
import org.tarea3.*;

public class panelSeleccionProducto extends JPanel {
    JPanel cocaPanel;
    JPanel spritePanel;
    JPanel fantaPanel;
    JPanel snickersPanel;
    JPanel super8Panel;
    JButton cocaBoton;
    JButton spriteBoton;
    JButton fantaBoton;
    JButton snickersBoton;
    JButton super8Boton;
    private JLabel stockCocaLabel;
    private int stockCoca;
    private JLabel stockSpriteLabel;
    private int stockSprite;
    private JLabel stockFantaLabel;
    private int stockFanta;
    private JLabel stockSnickersLabel;
    private int stockSnickers;
    private JLabel stockSuper8Label;
    private int stockSuper8;
    public panelSeleccionProducto(){
        super();
        this.setLayout(new GridLayout(3,2,10,10));
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.setBackground(Color.DARK_GRAY);

        JPanel cocaPanel = new JPanel();
        cocaPanel.setLayout(new BorderLayout());
        cocaPanel.setOpaque(false);
        stockCocaLabel = new JLabel(String.valueOf(stockCoca), JLabel.CENTER);
        stockCocaLabel.setForeground(Color.WHITE);
        ImageIcon cocaIcon = new ImageIcon(getClass().getResource("/img/coca.png"));
        cocaBoton = new JButton(cocaIcon);
        cocaBoton.setPreferredSize(new Dimension(80,120));
        cocaPanel.add(stockCocaLabel,BorderLayout.NORTH);
        cocaPanel.add(cocaBoton,BorderLayout.CENTER);
        this.add(cocaPanel);

        JPanel spritePanel = new JPanel();
        spritePanel.setLayout(new BorderLayout());
        spritePanel.setOpaque(false);
        stockSpriteLabel = new JLabel(String.valueOf(stockSprite), JLabel.CENTER);
        stockSpriteLabel.setForeground(Color.WHITE);
        ImageIcon spriteIcon = new ImageIcon(getClass().getResource("/img/sprite.png"));
        spriteBoton = new JButton(spriteIcon);
        spriteBoton.setPreferredSize(new Dimension(80,120));
        spritePanel.add(stockSpriteLabel,BorderLayout.NORTH);
        spritePanel.add(spriteBoton,BorderLayout.CENTER);
        this.add(spritePanel);

        JPanel fantaPanel = new JPanel();
        fantaPanel.setLayout(new BorderLayout());
        fantaPanel.setOpaque(false);
        stockFantaLabel = new JLabel(String.valueOf(stockFanta), JLabel.CENTER);
        stockFantaLabel.setForeground(Color.WHITE);
        ImageIcon fantaIcon = new ImageIcon(getClass().getResource("/img/fanta.png"));
        fantaBoton = new JButton(fantaIcon);
        fantaBoton.setPreferredSize(new Dimension(80,120));
        fantaPanel.add(stockFantaLabel,BorderLayout.NORTH);
        fantaPanel.add(fantaBoton,BorderLayout.CENTER);
        this.add(fantaPanel);

        JPanel snickersPanel = new JPanel();
        snickersPanel.setLayout(new BorderLayout());
        snickersPanel.setOpaque(false);
        stockSnickersLabel = new JLabel(String.valueOf(stockSnickers), JLabel.CENTER);
        stockSnickersLabel.setForeground(Color.WHITE);
        ImageIcon snickersIcon = new ImageIcon(getClass().getResource("/img/snickers.png"));
        snickersBoton = new JButton(snickersIcon);
        snickersBoton.setPreferredSize(new Dimension(80,120));
        snickersPanel.add(stockSnickersLabel,BorderLayout.NORTH);
        snickersPanel.add(snickersBoton,BorderLayout.CENTER);
        this.add(snickersPanel);

        JPanel super8Panel = new JPanel();
        super8Panel.setLayout(new BorderLayout());
        super8Panel.setOpaque(false);
        stockSuper8Label = new JLabel(String.valueOf(stockSuper8), JLabel.CENTER);
        stockSuper8Label.setForeground(Color.WHITE);
        ImageIcon super8Icon = new ImageIcon(getClass().getResource("/img/super8.png"));
        super8Boton = new JButton(super8Icon);
        super8Boton.setPreferredSize(new Dimension(80,120));
        super8Panel.add(stockSuper8Label,BorderLayout.NORTH);
        super8Panel.add(super8Boton,BorderLayout.CENTER);
        this.add(super8Panel);

    }



    public JButton getBotonCoca(){
        return cocaBoton;
    }
    public JButton getBotonSprite(){
        return spriteBoton;
    }
    public JButton getBotonFanta(){
        return fantaBoton;
    }
    public JButton getBotonSnickers(){
        return snickersBoton;
    }
    public JButton getBotonSuper8(){
        return super8Boton;
    }

    public void setStock(int producto,int nuevoStock) {
        if(producto == 0) {
         stockCoca = nuevoStock;
         stockCocaLabel.setText(String.valueOf(stockCoca));
        }else if(producto ==1){
            stockSprite = nuevoStock;
            stockSpriteLabel.setText(String.valueOf(stockSprite));
        }else if(producto ==2){
            stockFanta = nuevoStock;
            stockFantaLabel.setText(String.valueOf(stockFanta));
        }
        else if(producto == 3){
            stockSnickers = nuevoStock;
            stockSnickersLabel.setText(String.valueOf(stockSnickers));
        }else if(producto == 4){
            stockSuper8 = nuevoStock;
            stockSuper8Label.setText(String.valueOf(stockSuper8));
        }
    }
    public void setStockInicial(int stockInicial) {
        this.stockCoca = stockInicial;
        this.stockSprite = stockInicial;
        this.stockFanta = stockInicial;
        this.stockSnickers = stockInicial;
        this.stockSuper8 = stockInicial;
        stockCocaLabel.setText(String.valueOf(stockCoca));
        stockSpriteLabel.setText(String.valueOf(stockSprite));
        stockFantaLabel.setText(String.valueOf(stockFanta));
        stockSnickersLabel.setText(String.valueOf(stockSnickers));
        stockSuper8Label.setText(String.valueOf(stockSuper8));
    }

}
