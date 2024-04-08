package Milestones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Mile3 extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel imageLabel;
    private JComboBox combo;
    private JCheckBox checkBox;
    private JTextField textField;
    private JButton saveButton;
    private ImageIcon[] imageIcons;

    public Mile3(){
        super("Load Image");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(900,500));

        this.setLayout(null);
        panel = (JPanel) this.getContentPane();
        addWindowListener( new closeMessage() );

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
            System.exit(0);
        }

        //DESIGN OF THE WINDOW

        //Add the ComboBox
        String [] images = {"dragon.jpg", "garden.jpg", "shop.jpg"};
        combo = new JComboBox<>(images);

        combo.setSelectedIndex(0);
        combo.setBounds(20, 20, 200, 45);

        panel.add(combo);
        //System.out.println(combo.getSelectedIndex());

        imageIcons = new ImageIcon[]{
                new ImageIcon(new ImageIcon("Mile3_images/dragon.jpg").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT)),
                new ImageIcon(new ImageIcon("Mile3_images/garden.jpg").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT)),
                new ImageIcon(new ImageIcon("Mile3_images/shop.jpg").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT))
        };

        imageLabel = new JLabel(imageIcons[0]);
        imageLabel.setBounds(20, 100, 200, 200);
        panel.add(imageLabel);

        ComboListener comboListener = new ComboListener(combo, panel, imageLabel, imageIcons);
        combo.addActionListener(comboListener);


        //Add check box
        checkBox = new JCheckBox("Save your comment", true);
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

        saveButton.addActionListener(this);

        this.setVisible(true);
        this.pack();
    }
    //Closing action
    public class closeMessage extends WindowAdapter {
        public void windowClosing( WindowEvent e ) {
            JOptionPane.showMessageDialog
                    (null, "Bye","Input",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Mile3();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String fileName = "Buffer_Files/milestone3.txt";
        String imageName = imageLabel.getName();

        if (checkBox.isSelected()){
            BufferedWriter bw;
            String nextLine = "\n";
            try {
                bw = new BufferedWriter(new FileWriter(fileName, true));

                bw.append(nextLine);
                bw.append(imageName).append(" ").append(textField.getText());

                if (bw!=null){
                    bw.close();
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog
                    (null, "Your comment has been saved successfully!","Input",JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog
                    (null, "Your comment will not be saved!","Alert",JOptionPane.WARNING_MESSAGE);
        }

    }
}
