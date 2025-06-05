package Controladores;

import GUI.panelExpendedor;
import org.tarea3.DepositoLlenoException;
import org.tarea3.Expendedor;
import org.tarea3.NoHayProductoException;
import org.tarea3.PagoInsuficienteException;

public class ControladorExpendedor {
    private Expendedor exp;
    private panelExpendedor panelExp;

    public ControladorExpendedor(Expendedor expend, panelExpendedor panelExpend) {
        this.exp = expend;
        this.panelExp = panelExpend;

        exp.addPropertyChangeListener(evt -> {
            switch (evt.getPropertyName()) {
                case "Valor Monedas":
                    panelExp.getPanelInput().mostrarCambios(evt.getNewValue());
                    break;
                case "Producto en Deposito":
                    panelExp.getPanelOut().mostrarCambios(evt.getNewValue());
                case "Hay Vuelto":
                    panelExp.getPanelInput().mostrarVuelto(evt.getNewValue());
            }
        });
        panelExp.getPanSelProd().getBotonCoca().addActionListener(e -> {
            exp.setProductoSeleccionado(0);
            panelExp.getPanelInput().getProducto().setText("COCA COLA");
        });
        panelExp.getPanSelProd().getBotonSprite().addActionListener(e -> {
            exp.setProductoSeleccionado(1);
            panelExp.getPanelInput().getProducto().setText("SPRITE");
        });
        panelExp.getPanSelProd().getBotonFanta().addActionListener(e -> {
            exp.setProductoSeleccionado(2);
            panelExp.getPanelInput().getProducto().setText("FANTA");
        });
        panelExp.getPanSelProd().getBotonSnickers().addActionListener(e -> {
            exp.setProductoSeleccionado(3);
            panelExp.getPanelInput().getProducto().setText("SNICKERS");
        });
        panelExp.getPanSelProd().getBotonSuper8().addActionListener(e -> {
            exp.setProductoSeleccionado(4);
            panelExp.getPanelInput().getProducto().setText("SUPER 8");
        });
        panelExp.getPanelInput().getBotonComprar().addActionListener(e -> {
            try{
                exp.compraDeProducto();
                panelExp.getPanelInput().getNotificacion().setText("COMPRA EXITOSA");

            }catch (Exception ex) {
                if (ex instanceof NoHayProductoException) {
                    panelExp.getPanelInput().getNotificacion().setText("PRODUCTO AGOTADO");
                } else if (ex instanceof PagoInsuficienteException) {
                    panelExp.getPanelInput().getNotificacion().setText("DINERO INSUFICIENTE");
                } else if (ex instanceof DepositoLlenoException) {
                    panelExp.getPanelInput().getNotificacion().setText("RETIRE PRODUCTO ANTES DE HACER OTRA COMPRA");
                }
            }
        });

        panelExp.getPanelOut().getProductoComprado().addActionListener(e -> {
            try {
                exp.getProductoComprado();
            }catch (Exception ex){
                panelExp.getPanelInput().getNotificacion().setText("NO HAY PRODUCTO PARA RETIRAR");
                panelExp.getPanelInput().mostrarCambios(e.ge);
            }
        });
    }
}