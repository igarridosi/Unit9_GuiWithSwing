package Milestones;

import javax.swing.*;
import java.awt.*;

public class Mile4 extends JFrame {
    private Container container;
    private JComboBox<String> combo;
    private JList<String> jList;
    private JLabel label;
    private ImageIcon icon;
    public Mile4(){
        super("Photography");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(900, 500));

        container = getContentPane();
        container.setLayout(new GridLayout(2,2));

        String[] array = {"Name1", "Name2", "Name3"};
        combo = new JComboBox<>(array);

        container.add(combo);



        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Mile4();
    }
}
