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

        JPanel eastPanel = new JPanel();
        eastPanel.setPreferredSize(new Dimension(250,getHeight()));
        eastPanel.setBackground(new Color(149, 176, 204));

        ButtonGroup bg = new ButtonGroup();

        JRadioButton opt1 = new JRadioButton("OPT1");
        opt1.setBounds(20, 30, getWidth(), getHeight());
        eastPanel.add(opt1);
        bg.add(opt1);

        JRadioButton opt2 = new JRadioButton("OPT2");
        eastPanel.add(opt2);
        bg.add(opt2);

        JRadioButton opt3 = new JRadioButton("OPT3");
        eastPanel.add(opt3);
        bg.add(opt3);

        container.add(eastPanel, BorderLayout.EAST);


        //3//

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
        southPanel.setPreferredSize(new Dimension(getWidth(),50));
        southPanel.setBackground(new Color(129,123,212));

        JButton but1 = new JButton("But1");
        JButton but2 = new JButton("But2");

        southPanel.add(but1);
        southPanel.add(but2);

        container.add(southPanel, BorderLayout.SOUTH);

        //4//

        JPanel centerPanel = new JPanel(new GridLayout(2,2));

        centerPanel.setBackground(new Color(209, 222, 87));

        //Create an array of labels and images for adding to each cell of the GridLayout
        JLabel[] labels = new JLabel[4];
        ImageIcon[] images = new ImageIcon[4];

        images[0] = new ImageIcon("E:\\WG31 Zubiri\\Programming\\Java_ex\\Unit9_GuiWithSwing\\src\\Milestone1\\katniss.jpg");
        images[1] = new ImageIcon("E:\\WG31 Zubiri\\Programming\\Java_ex\\Unit9_GuiWithSwing\\src\\Milestone1\\katniss.jpg");
        images[2] = new ImageIcon("E:\\WG31 Zubiri\\Programming\\Java_ex\\Unit9_GuiWithSwing\\src\\Milestone1\\katniss.jpg");
        images[3] = new ImageIcon("E:\\WG31 Zubiri\\Programming\\Java_ex\\Unit9_GuiWithSwing\\src\\Milestone1\\katniss.jpg");

        for (int i=0; i<4; i++){
            labels[i] = new JLabel(images[i]);
            centerPanel.add(labels[i]);
        }

        container.add(centerPanel, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }


    public static void main(String[] args) {
        new Mile1();
    }
}
