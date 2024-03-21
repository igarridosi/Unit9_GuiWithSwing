package Milestones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mile2 extends JFrame implements ActionListener {
    private Container container;
    private JPanel center, east;
    private JComboBox combo;
    private JTextArea textArea;
    private JButton clear, close;

    public Mile2(){
        super("Test events: File");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(900, 500));

        container = getContentPane();
        container.setLayout(new BorderLayout());

        //Adding the panels of the container
        center = new JPanel(new FlowLayout());
        center.setBackground(new Color(243));

        east = new JPanel();
        east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
        east.setBackground(new Color(0x34DA2E));

        container.add(center, BorderLayout.CENTER);
        container.add(east, BorderLayout.EAST);


        //Adding comboBox and button
        String [] files = {"python.txt", "c.txt", "java.txt"};
        combo = new JComboBox<>(files);
        combo.setSelectedIndex(0);

        center.add(combo);

        clear = new JButton("Clear");
        center.add(clear);


        //Adding text field with scroll bar and button
        textArea = new JTextArea(20, 35);
        JScrollPane scroll1 = new JScrollPane();

        scroll1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll1.setBounds(10,10,100, 100);
        scroll1.setViewportView(textArea);

        east.add(scroll1);

        close = new JButton("Close");

        east.add(close);

        //Adding the action listener of the ComboBox
        combo.addActionListener(this);

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Mile2();
    }

    //Action lister method for the different opt of the CBox
    @Override
    public void actionPerformed(ActionEvent e) {
        String opt = (String) combo.getSelectedItem();

        switch (opt){
            case "python.txt":
                textArea.setText("python information here...");
                break;
            case "c.txt":
                textArea.setText("c information here...");
                break;
            case "java.txt":
                textArea.setText("java information here...");
                break;
        }
    }


}
