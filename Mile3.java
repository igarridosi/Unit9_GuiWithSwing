package Milestones;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Mile3 extends JFrame {
    private Container container;
    private JPanel panel;
    private JComboBox combo;

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

        //Add the container
        container = getContentPane();

        //Add the ComboBox
        String [] images = {"dragon.jpg", "garden.jpg", "shop.jpg"};
        combo = new JComboBox<>(images);

        combo.setSelectedIndex(0);
        combo.setBounds(20, 20, 200, 45);

        panel.add(combo);


        this.setVisible(true);
        this.pack();
    }

    public static void main(String[] args) {
        new Mile3();
    }
}
