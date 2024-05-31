package main.visual;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JFrame {

    private PanelComprador com;
    private PanelExpendedor exp;

    public PanelPrincipal() {
        super("Expendedor de Productos");

        // Panel Expendedor
        exp = new PanelExpendedor();

        // Panel Comprador
        com = new PanelComprador();

        ImageIcon icono = new ImageIcon("src/main/resources/cocacola.png");

        // Panel Principal
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
    }

    /*
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        com.paintComponents(g);
        exp.paintComponents(g);
    }
     */


}
