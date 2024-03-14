package Milestone1;

import javax.swing.*;
import java.awt.*;

public class Mile1 extends JFrame {
    public Mile1(){
        super("Try yourself");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(900,500));

        Container panel = getContentPane();

        panel.setLayout(new BorderLayout());

        panel.add(new JCheckBox("Katniss"), BorderLayout.NORTH);
        panel.add(new JCheckBox("Peeta"), BorderLayout.SOUTH);

        //https://www.geeksforgeeks.org/java-awt-borderlayout-class/

        this.pack();
        this.setVisible(true);
    }


    public static void main(String[] args) {
        Mile1 m1 = new Mile1();
    }
}
