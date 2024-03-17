package Milestone1;

import javax.swing.*;
import java.awt.*;

public class Mile1 extends JFrame {
    public Mile1(){
        super("Try yourself");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(900,500));

        //1//

        //Create the main container with BorderLayout
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        //Add a new JPanel inside the container with FLowLayout
        JPanel northPanel = new JPanel(new FlowLayout());

        //Add the panel to the North position of the container
        container.add(northPanel, BorderLayout.NORTH);

        //Add the CheckBoxes to the North Panel
        northPanel.add(new JCheckBox("Katniss"));
        northPanel.add(new JCheckBox("Peeta"));

        //2//



        this.pack();
        this.setVisible(true);
    }


    public static void main(String[] args) {
        Mile1 m1 = new Mile1();
    }
}
