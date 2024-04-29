package Milestones;

import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Mile5 extends JFrame{
    private Container container;
    private JPanel panel1, panel2, panel3, panel4, headLeft, headRight;
    private JComboBox<String> combo;
    private JList<String> jList;
    private JScrollPane scroll1;
    private JLabel label1, label2, imageLabel;
    private ImageIcon icon;
    private JButton award, remove;
    private JXDatePicker datePicker;
    private Mile4DB db = new Mile4DB();
    public Mile5(){
        super("Photography");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(900, 500));

        //For closing the Database
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                db.finish();
                System.out.println("DB connection closed");
            }
        });

        container = getContentPane();
        container.setLayout(new GridLayout(3,2));

//////////Combo Names//////////////////////////////////

        //Adding ComboBox to panel1
        panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        label1 = new JLabel("Photographer: ");

        //Array for changing the values of the jList
        String [] photographerNames = photographerNames();
        combo = new JComboBox<>(photographerNames);
        combo.setSize(100, 40);

        panel1.add(label1);
        panel1.add(combo);

/////////////Date/////////////////////////////

        //Adding the Date box to panel2
        panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        label2 = new JLabel("Photos after ");

        panel2.add(label2);


////////////JList Title////////////////////////////

        //Adding JList to panel3
        panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));

        jList = new JList<>();

        //Set a pictureNames list by default
        String [] pictureNames = pictureNames(0);
        jList.setListData(pictureNames);


        //Listener for changing the values of the jList
        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int index = combo.getSelectedIndex();
                String [] pictureNames = pictureNames(index);
                jList.setListData(pictureNames);

            }
        });

        //Adding the scroll bar to the JList
        scroll1 = new JScrollPane();

        scroll1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll1.setBounds(10,10,100, 100);
        scroll1.setViewportView(jList);

        panel3.add(scroll1);

///////////////JLabel Image///////////////////////////

        //Adding the JLabel with the ImageIcon to panel4
        panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));


        final String[] selectedTitle = {" "};
        imageLabel = new JLabel();

        //Set an image by default
        icon = new ImageIcon("Mile4_Images/ansealdams1.jpg");
        icon.setImage(icon.getImage().getScaledInstance(250, 150, Image.SCALE_DEFAULT));
        imageLabel.setIcon(icon);

        jList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
                    //System.out.println("double clicked");

                    //Calling a method for returning the Selected Picture
                    Picture selectedPicture = getSelectedPicture(selectedPhotographer(combo.getSelectedIndex()).getId());

                    selectedTitle[0] = selectedPicture.getFile();
                    //System.out.println(selectedTitle[0]);

                    icon = new ImageIcon(selectedTitle[0]);
                    icon.setImage(icon.getImage().getScaledInstance(250, 150, Image.SCALE_DEFAULT));
                    imageLabel.setIcon(icon);

                    panel4.revalidate();
                    panel4.repaint();

                }
            }
        });

        panel4.add(imageLabel);



        datePicker = new JXDatePicker();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        //Set a default date
        try {
            Date date = sdf.parse("27/02/2013");
            datePicker.setDate(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        panel2.add(datePicker);

//////////////JButtons/////////////////////////////
        award = new JButton("AWARD");
        remove = new JButton("REMOVE");

        headLeft = new JPanel(new BorderLayout());
        headRight = new JPanel(new BorderLayout());

        award.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int minVisits = Integer.parseInt(JOptionPane.showInputDialog("Input the N. of Visits to the pictures must be marked as awarded"));

                Map<Integer, Integer> visitsMap = db.createVisitsMap();
                for (Map.Entry<Integer, Integer> entry : visitsMap.entrySet()){
                    //System.out.println(entry.getValue());
                    //System.out.println(minVisits);
                    if (entry.getValue()>=minVisits){
                        db.updatePhotographerAwarded(entry.getKey());
                    }
                }
            }
        });

        headLeft.add(award, BorderLayout.CENTER);
        headRight.add(remove, BorderLayout.CENTER);




//////////////Add Panels/////////////////////////////

        //Adding panels to the container
        container.add(headLeft);
        container.add(headRight);
        container.add(panel1);
        container.add(panel2);
        container.add(panel3);
        container.add(panel4);

        /*
        //Check the visitsMap
        Map<Integer, Integer> visits = db.createVisitsMap();
        for (Map.Entry<Integer, Integer> entry : visits.entrySet()){
            System.out.println(entry.getKey() +" "+ entry.getValue());
        }
         */


        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Mile5();
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

    public Picture getSelectedPicture(int photographerId){
        List<Picture> pictureList = db.pictureList();
        Picture returnPicture;

        for (Picture picture: pictureList){
            if(picture.getPhotographerId() == photographerId && jList.getSelectedValue().equals(picture.getTitle())){
                returnPicture = picture;
                return returnPicture;
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

    public String[] picturePath(int selectedIndex){
        Photographer p1 = selectedPhotographer(selectedIndex);

        List<Picture> pictureList = db.pictureList();

        String [] picturePaths = new String[pictureList.size()];

        int i=0;
        for (Picture picture : pictureList){
            if (p1.getId() == picture.getPhotographerId()){
                picturePaths[i] = picture.getFile();
            }
            i++;
        }

        return picturePaths;
    }

}
