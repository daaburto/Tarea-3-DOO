package main.visual;

import main.java.Expendedor;
import main.java.Enum;
import javax.swing.*;
import java.awt.*;
import static main.visual.Musica.music;

/**
 * PanelExpendedor representa el panel de una máquina expendedora en la interfaz gráfica.
 * Este panel contiene botones para los productos, etiquetas con los precios y un botón para rellenar los productos.
 * @see Expendedor
 * @author Daniel Aburto
 */
public class PanelExpendedor extends JPanel {
    /**
     * Array de botones de productos.
     * @see ProductoButton
     */
    private static ProductoButton[] productos;

    /**
     * Array de etiquetas para mostrar los precios de los productos.
     */
    private static JLabel[] etiquetasPrecios;

    /**
     * Botón para rellenar los productos en la máquina expendedora.
     */
    private JButton boton;

    /**
     * Índice del producto seleccionado.
     */
    public static int productoSeleccionado = 1;

    /**
     * Array de imágenes de los productos.
     */
    private String[] imagenes = {
            "src/main/resources/coca.png",
            "src/main/resources/sprite.png",
            "src/main/resources/fanta.png",
            "src/main/resources/snickers.png",
            "src/main/resources/super8.png",
            "src/main/resources/chokita.png"
    };

    /**
     *  Cantidades iniciales de los productos en el expendedor
     */
    private int[] cantidades = {3, 3, 3, 3, 3, 3};

    /**
     * Precios de los productos.
     */
    private int[] precios = {Enum.COCA.getValor(), Enum.SPRITE.getValor(),Enum.FANTA.getValor(), Enum.SNICKERS.getValor(), Enum.SUPER8.getValor(), Enum.CHOKITA.getValor()};

    /**
     * Objeto Expendedor para manejar la lógica de la máquina expendedora.
     */
    public static Expendedor exp = new Expendedor(3);


    /**
     * Constructor de PanelExpendedor.
     * Configura el panel, inicializa los botones de productos y las etiquetas de precios.
     */
    public PanelExpendedor() {
        super();
        this.setBackground(Color.GRAY);
        this.setLayout(new BorderLayout());
        this.setBounds(10, 10, 900, 666);

        productos = new ProductoButton[6];
        etiquetasPrecios = new JLabel[6];
        JPanel productosPanel = new JPanel();
        productosPanel.setLayout(new GridLayout(2, 3, 10, 10));
        productosPanel.setBackground(Color.GRAY);

        // Botones
        for (int i = 0; i < 6; i++) {
            JPanel productoPanel = new JPanel();
            productoPanel.setLayout(new BorderLayout());
            productoPanel.setBackground(Color.LIGHT_GRAY);
            productoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            ImageIcon icon = new ImageIcon(imagenes[i]);
            Image img = icon.getImage().getScaledInstance(250, 150, Image.SCALE_SMOOTH);
            productos[i] = new ProductoButton(new ImageIcon(img), cantidades[i]);
            productos[i].setBackground(Color.LIGHT_GRAY);
            productos[i].setOpaque(true);
            productos[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            int aux = i;
            productos[i].addActionListener(e -> seleccionarProducto(aux));

            etiquetasPrecios[i] = new JLabel("$" + precios[i], SwingConstants.CENTER);
            etiquetasPrecios[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));

            productoPanel.add(productos[i], BorderLayout.CENTER);
            productoPanel.add(etiquetasPrecios[i], BorderLayout.SOUTH);

            productosPanel.add(productoPanel);
        }

        boton = new JButton("RELLENAR");
        boton.addActionListener(e -> rellenarProductos());
        this.add(boton, BorderLayout.NORTH);
        this.add(productosPanel, BorderLayout.CENTER);
    }

    /**
     * Método para seleccionar un producto en la interfaz gráfica, remarcándolo con un borde rojo y sonido
     * @param i índice del producto seleccionado
     */
    private void seleccionarProducto(int i) {
        productoSeleccionado = i;
        for (ProductoButton producto : productos) {
            producto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
        productos[i].setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        music.ButtonExpendedor();
    }

    /**
     * Reduce la cantidad del producto seleccionado, quitando una imagen de ese producto.
     * @see ProductoButton
     */
    public static void reducirCantidadProductoSeleccionado() {
        productos[productoSeleccionado].reducirCantidad();
    }

    /**
     * Rellena los productos en la máquina expendedora, solo de aquellos cuya cantidad es cero.
     * @see Expendedor
     */
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
}