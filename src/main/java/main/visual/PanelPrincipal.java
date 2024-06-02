package main.visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPrincipal extends JFrame {

    private PanelComprador com;
    private PanelExpendedor exp;
    private PanelDepositoMonedas dep;
    public PanelPrincipal() {
        super("Expendedor de Productos");

        // Panel Expendedor
        exp = new PanelExpendedor();

        // Panel Comprador
        com = new PanelComprador();

        // JDialog Monedero
        dep = new PanelDepositoMonedas(this);

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
        dep.setLocation(this.getX() + this.getWidth()-200,this.getY());
        Musica musica = new Musica();
        musica.playMusic();
        //this.add(dep);
    }
}
