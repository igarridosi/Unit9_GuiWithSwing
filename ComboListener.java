package Milestones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboListener implements ActionListener {
    private JComboBox combo;
    private JPanel panel;

    public ComboListener(JComboBox combo, JPanel panel) {
        this.combo = combo;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedIndex = combo.getSelectedIndex();

        //Load the image based on the selected index
        ImageIcon imageIcon;
        JLabel imageLabel = new JLabel();

        switch (selectedIndex) {
            case 0:
                imageIcon = new ImageIcon("Mile3_images/dragon.jpg");
                break;
            case 1:
                imageIcon = new ImageIcon("Mile3_images/garden.jpg");
                break;
            case 2:
                imageIcon = new ImageIcon("Mile3_images/shop.jpg");
                break;
            default:
                imageIcon = null;
        }

        imageLabel.setIcon(imageIcon);
        panel.add(imageLabel);


    }
}
