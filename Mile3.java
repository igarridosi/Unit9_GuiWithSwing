package Milestones;

import javax.swing.*;
import java.awt.*;

public class Mile3 extends JFrame {
    public Mile3(){
        super("Load Image");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(900,500));




        this.setVisible(true);
        this.pack();
    }

    public static void main(String[] args) {
        new Mile3();
    }
}
