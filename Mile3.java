package Milestones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Mile3 extends JFrame{
    private Container container;
    private JPanel panel;
    private JLabel label;
    private JComboBox combo;
    private ImageIcon imageIcon;
    private JCheckBox checkBox;
    private JTextField textField;
    private JButton saveButton;

    public Mile3(){
        super("Load Image");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(900,500));

        this.setLayout(null);
        panel = (JPanel) this.getContentPane();

        //Password check
        /*
        JPasswordField passwordField = new JPasswordField();
        Object[] message = {"Enter Password:", passwordField};

        int option = JOptionPane.showConfirmDialog(null, message, "Password Prompt", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            char[] password = passwordField.getPassword();
            String enteredPassword = new String(password);

            if (enteredPassword.equals("damocles")) {
                System.out.println("Entered Password: " + enteredPassword);
            }
            else{
                System.out.println("Wrong pass");
                System.exit(0);
            }
        }
        else {
            System.out.println("Canceled the operation.");
            System.exit(0);
        }

         */

        //DESIGN OF THE WINDOW

        //Add the ComboBox
        String [] images = {"dragon.jpg", "garden.jpg", "shop.jpg"};
        combo = new JComboBox<>(images);

        combo.setSelectedIndex(0);
        combo.setBounds(20, 20, 200, 45);

        panel.add(combo);
        System.out.println(combo.getSelectedIndex());












        //Add check box
        checkBox = new JCheckBox("Save your comment");
        checkBox.setBounds(50, 300, 200,50);
        checkBox.isSelected();
        panel.add(checkBox);

        //Add the Text Area
        textField = new JTextField(10);
        textField.setBounds(310, 300, 250, 40);
        panel.add(textField);

        //Add save Button
        saveButton = new JButton("SAVE");
        saveButton.setBounds(200, 400, 100, 40);
        panel.add(saveButton);

        this.setVisible(true);
        this.pack();
    }

    public static void main(String[] args) {
        new Mile3();
    }

    public void load_combo(){
        int selectedIndex = combo.getSelectedIndex();

        //Load the image based on the selected index
        ImageIcon imageIcon;
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

        if (imageIcon != null) {
            panel.add(new JLabel(imageIcon));
        }
    }
}
