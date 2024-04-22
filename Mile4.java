package Milestones;

import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Mile4 extends JFrame {
    private Container container;
    private JPanel panel1, panel2, panel3, panel4;
    private JComboBox<String> combo;
    private JList<String> jList;
    private JScrollPane scroll1;
    private JLabel label1, label2, imageLabel;
    private ImageIcon icon;
    private JXDatePicker datePicker;
    private Mile4DB db = new Mile4DB();
    public Mile4(){
        super("Photography");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(900, 500));

        container = getContentPane();
        container.setLayout(new GridLayout(2,2));

        //Adding ComboBox to panel1
        panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        label1 = new JLabel("Photographer: ");

        String [] photographerNames = photographerNames();

        combo = new JComboBox<>(photographerNames);
        combo.setSize(100, 40);

        //Listener for changing the values of the jList
        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int index = combo.getSelectedIndex();
                String [] pictureNames = pictureNames(index);
                jList.setListData(pictureNames);

            }
        });

        panel1.add(label1);
        panel1.add(combo);

        //Adding the Date box to panel2
        panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        label2 = new JLabel("Photos after ");

        panel2.add(label2);

        //Adding JList to panel3
        panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        jList = new JList<>();
        jList.setPreferredSize(new Dimension(350, 200));


        //Adding the scroll bar to the JList
        scroll1 = new JScrollPane();

        scroll1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll1.setBounds(10,10,100, 100);
        scroll1.setViewportView(jList);

        panel3.add(scroll1);



        //Adding the JLabel with the ImageIcon to panel4
        panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        imageLabel = new JLabel();
        icon = new ImageIcon("Mile4_Images/vangogh1.jpg");
        imageLabel.setIcon(icon);

        panel4.add(imageLabel);

        datePicker = new JXDatePicker();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        panel2.add(datePicker);

        //Adding panels to the container
        container.add(panel1);
        container.add(panel2);
        container.add(panel3);
        container.add(panel4);

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Mile4();
    }

    public String[] photographerNames(){
        List<Photographer> photographerList = db.photographerList();
        String [] photographerNames = new String[photographerList.size()];

        int i = 0;
        for (Photographer photographer : photographerList){
            //System.out.println(photographer.getName());
            photographerNames[i] = photographer.getName();
            i++;
        }

        return photographerNames;
    }

    public Photographer selectedPhotographer(int selectedIndex){
        String [] photographersNames = photographerNames();

        List<Photographer> photographerList = db.photographerList();

        for (Photographer photographer: photographerList){
            if(photographer.getName().equals(photographersNames[selectedIndex])){
                return photographer;
            }
        }

        return null;
    }

    public String[] pictureNames(int selectedIndex){
        Photographer photographer = selectedPhotographer(selectedIndex);

        List<Picture> pictureList = db.pictureList();

        String [] pictureNames = new String[pictureList.size()];

        int i=0;
        for (Picture picture : pictureList){
            if (picture.getPhotographerId() == photographer.getId()){
                pictureNames[i] = picture.getTitle();
            }
            i++;
        }

        return pictureNames;
    }
}
