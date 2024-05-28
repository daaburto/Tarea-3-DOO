package main.visual;

import main.java.*;

import javax.swing.*;
import java.awt.*;

public class PanelExpendedor extends JPanel {

    PanelExpendedor(){
        super();
        JPanel panelexpendedor = new JPanel();
        this.setBackground(Color.GRAY);
        this.setBounds(10,10,900,666);
        this.setLayout(new CardLayout());

        this.setVisible(true);


    }
}
