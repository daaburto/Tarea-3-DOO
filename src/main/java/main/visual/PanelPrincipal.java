package main.visual;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JFrame {

    public PanelPrincipal(){
        super("Expendedor de Productos");


        // Panel Expendedor
        PanelExpendedor panelexpendedor = new PanelExpendedor();

        // Panel Comprador
        PanelComprador panelcomprador = new PanelComprador();

        // Panel Principal
        JPanel panelprincipal = new JPanel();
        panelprincipal.setBounds(0,0, 1280, 720);
        panelprincipal.setLayout(new CardLayout());
        panelprincipal.setBackground(Color.DARK_GRAY);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(1280,720);
        this.setVisible(true);
        this.add(panelcomprador);
        this.add(panelexpendedor);
        this.add(panelprincipal);



    }
}
