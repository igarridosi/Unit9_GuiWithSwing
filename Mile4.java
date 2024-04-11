package Milestones;

import javax.swing.*;
import java.awt.*;

public class Mile4 extends JFrame {
    private Container container;
    private JPanel panel1, panel2;
    private JComboBox<String> combo;
    private JList<String> jList;
    private JScrollPane scroll1;
    private JLabel label1, label2;
    private ImageIcon icon;
    public Mile4(){
        super("Photography");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(900, 500));

        container = getContentPane();
        container.setLayout(new GridLayout(2,2));

        //Adding ComboBox to panel1
        panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        label1 = new JLabel("Photographer: ");

        String[] array = {"Name1", "Name2", "Name3"};
        combo = new JComboBox<>(array);
        combo.setSize(100, 40);

        panel1.add(label1);
        panel1.add(combo);
        container.add(panel1);

        //Adding JList to panel2
        panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        String[] dataList = {"Bellet", "Sunsel"};
        jList = new JList<>(dataList);
        jList.setPreferredSize(new Dimension(350, 200));

        //Adding the scroll bar to the JList
        scroll1 = new JScrollPane();

        scroll1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll1.setBounds(10,10,100, 100);
        scroll1.setViewportView(jList);

        panel2.add(scroll1);
        container.add(panel2);


        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Mile4();
    }
}
