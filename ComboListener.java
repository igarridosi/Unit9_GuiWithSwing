package Milestones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboListener implements ActionListener {

    private JComboBox combo;
    private JPanel panel;
    private ImageIcon[] imageIcons;
    private JLabel imageLabel;

    public ComboListener(JComboBox combo, JPanel panel, JLabel imageLabel, ImageIcon[] imageIcons) {
        this.combo = combo;
        this.panel = panel;
        this.imageLabel = imageLabel;
        this.imageIcons = imageIcons;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedIndex = combo.getSelectedIndex();
        //System.out.println(selectedIndex);

        ImageIcon selectedIcon = imageIcons[selectedIndex];
        imageLabel.setIcon(selectedIcon);
        //Getting the name of the images (not working)
        System.out.println(imageLabel.getName());
        panel.add(imageLabel);

    }
}
