package Milestones;

import javax.swing.*;
import java.awt.*;

public class Mile2 extends JFrame {
    public Mile2(){
        super("Test events: File");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(900, 500));




        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Mile2();
    }
}
