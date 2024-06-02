package main.visual;

import javax.swing.*;
import java.awt.*;

/**
 * PanelPrincipal representa la ventana principal de la máquina expendedora.
 * Esta ventana contiene el panel del expendedor y el panel del comprador.
 */
public class PanelPrincipal extends JFrame {
    /**
     * Panel para el comprador.
     */
    private PanelComprador com;

    /**
     * Panel para el expendedor.
     */
    private PanelExpendedor exp;

    /**
     * Constructor de PanelPrincipal.
     * Configura la ventana principal, inicializa los paneles y establece sus propiedades.
     */
    public PanelPrincipal() {
        super("Expendedor de Productos");
        exp = new PanelExpendedor();
        com = new PanelComprador();
        ImageIcon icono = new ImageIcon("src/main/resources/cocacola.png");


        JPanel panelprincipal = new JPanel();
        panelprincipal.setBounds(0, 0, 1280, 720);
        panelprincipal.setLayout(new CardLayout());
        panelprincipal.setBackground(Color.DARK_GRAY);
        this.setIconImage(icono.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(1280, 720);
        this.setVisible(true);
        this.add(com);
        this.add(exp);
        this.add(panelprincipal);
        Musica musica = new Musica();
        musica.playMusic();
    }
}