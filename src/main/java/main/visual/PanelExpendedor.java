package main.visual;

import main.java.*;
import main.java.Enum;

import javax.swing.*;
import java.awt.*;

public class PanelExpendedor extends JPanel {
    private ProductoButton[] productos;
    private JButton boton;
    private int productoSeleccionado;
    private String[] imagenes = {"src/main/resources/coca.png", "src/main/resources/sprite.png", "src/main/resources/fanta.png",
            "src/main/resources/snickers.png", "src/main/resources/super8.png", "src/main/resources/chokita.png"};
    private int[] cantidades = {1, 2, 0, 5, 0, 6};  // Cantidades iniciales de los productos

    private Expendedor exp;
    public PanelExpendedor() {
        super();
        this.setBackground(Color.GRAY);
        this.setLayout(new BorderLayout());
        this.setBounds(10, 10, 900, 666);
        Expendedor exp = new Expendedor(6);

        productos = new ProductoButton[6];
        JPanel productosPanel = new JPanel();
        productosPanel.setLayout(new GridLayout(2, 3, 10, 10));
        productosPanel.setBackground(Color.GRAY);

        // Botones
        for (int i = 0; i < 6; i++) {
            ImageIcon icon = new ImageIcon(imagenes[i]);
            Image img = icon.getImage().getScaledInstance(250, 150, Image.SCALE_SMOOTH);
            productos[i] = new ProductoButton(new ImageIcon(img), cantidades[i]);
            productos[i].setBackground(Color.LIGHT_GRAY);
            productos[i].setOpaque(true);
            productos[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            int aux = i;
            productos[i].addActionListener(e -> seleccionarProducto(aux));
            productosPanel.add(productos[i]);
        }

        boton = new JButton("RELLENAR");
        boton.addActionListener(e -> rellenarProductos());
        this.add(boton, BorderLayout.NORTH);
        this.add(productosPanel, BorderLayout.CENTER);
    }

    private void seleccionarProducto(int i) {
        productoSeleccionado = i;
        for (ProductoButton producto : productos) {
            producto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
        productos[i].setBorder(BorderFactory.createLineBorder(Color.RED, 5));
    }

    public void reducirCantidadProductoSeleccionado() {
        productos[productoSeleccionado].reducirCantidad();
        //    exp.comprarProducto([Moneda],productoSeleccionado);
    }

    private void rellenarProductos() {
        for (int i = 0; i < productos.length; i++) {
            ProductoButton producto = productos[i];
            if (producto.getCantidad() == 0) {
                producto.setCantidad(6);
                switch (i) {
                    case 0:
                        exp.rellenarDeposito(Enum.COCA, 6);
                        break;
                    case 1:
                        exp.rellenarDeposito(Enum.SPRITE, 6);
                        break;
                    case 2:
                        exp.rellenarDeposito(Enum.FANTA, 6);
                        break;
                    case 3:
                        exp.rellenarDeposito(Enum.SNICKERS, 6);
                        break;
                    case 4:
                        exp.rellenarDeposito(Enum.SUPER8, 6);
                        break;
                    case 5:
                        exp.rellenarDeposito(Enum.CHOKITA, 6);
                        break;
                }

                producto.repaint();
            }
        }
    }

    public Expendedor getExpendedor() {
        return exp;
    }

    public int getProductoSeleccionado(){
        return productoSeleccionado;
    }
}


