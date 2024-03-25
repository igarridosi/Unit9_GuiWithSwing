package Milestones;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Mile3 extends JFrame {
    public Mile3(){
        super("Load Image");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(900,500));

        //Password check
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
        }

        this.setVisible(true);
        this.pack();
    }

    public static void main(String[] args) {
        new Mile3();
    }
}
