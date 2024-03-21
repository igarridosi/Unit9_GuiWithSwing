package Milestones;

import javax.swing.*;
import java.awt.*;

public class Mile2 extends JFrame {
    public Mile2(){
        super("Test events: File");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(900, 500));

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        //Adding the panels of the container
        JPanel center = new JPanel(new FlowLayout());
        center.setBackground(new Color(243));

        JPanel east = new JPanel();
        east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
        east.setBackground(new Color(0x34DA2E));

        container.add(center, BorderLayout.CENTER);
        container.add(east, BorderLayout.EAST);


        //Adding comboBox and button
        String [] files = {"python.txt", "c.txt", "java.txt"};
        JComboBox combo = new JComboBox<>(files);
        combo.setSelectedIndex(0);

        center.add(combo);

        JButton clear = new JButton("Clear");
        center.add(clear);


        //Adding text field with scroll bar and button
        JTextField textField = new JTextField(35);
        JScrollPane scroll1 = new JScrollPane();

        scroll1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll1.setBounds(10,10,100, 100);
        scroll1.setViewportView(textField);

        east.add(scroll1);

        JButton close = new JButton("Close");

        east.add(close);

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Mile2();
    }
}
