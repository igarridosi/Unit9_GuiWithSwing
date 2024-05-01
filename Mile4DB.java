package Milestones;

import org.jdesktop.swingx.JXDatePicker;

import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.stream.Stream;

public class Mile4DB {
    static final String SERVER_IP = "localhost";
    static final String DB_NAME = "Mile4DB";
    static final String USER = "root";
    static final String PASSWORD = "root";
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://"+SERVER_IP + ":3306/" + DB_NAME;
    private Connection conn;

    public Mile4DB(){
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to the database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Photographer> photographerList(){
        List<Photographer> photographerList = new ArrayList<>();

        try{
            PreparedStatement select = conn.prepareStatement("SELECT * FROM photographers");
            ResultSet rs = select.executeQuery();

            while (rs.next()){
                int id = rs.getInt("photographerId");
                String name = rs.getString("name");
                int awarded = rs.getInt("awarded");

                Photographer p1 = new Photographer(id, name, awarded);

                photographerList.add(p1);

            }

            select.close();
            rs.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return photographerList;

    }

    public List<Picture> pictureList() {
        List<Picture> pictureList = new ArrayList<>();

        try {
            PreparedStatement select = conn.prepareStatement("SELECT * FROM pictures");
            ResultSet rs = select.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("pictureId");
                String title = rs.getString("title");
                Date date = rs.getDate("date");
                String file = rs.getString("file");
                int visits = rs.getInt("visits");
                int photographerId = rs.getInt("photographerId");

                Picture p1 = new Picture(id, title, date, file, visits, photographerId);

                pictureList.add(p1);

            }

            select.close();
            rs.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return pictureList;
    }

    public Map<Integer, Integer> createVisitsMap(){
        Map<Integer, Integer> visitsMap = new HashMap<>();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM pictures");

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int numVisits = rs.getInt("visits");
                int photographerId = rs.getInt("photographerId");

                if (visitsMap.containsKey(photographerId)){
                    for (Map.Entry<Integer, Integer> entry: visitsMap.entrySet()){
                        if (visitsMap.containsKey(photographerId)){
                            visitsMap.put(photographerId, entry.getValue() + numVisits);
                        }
                    }
                }
                else {
                    visitsMap.put(photographerId, numVisits);
                }
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return visitsMap;
    }

    public void updatePhotographerAwarded(int photographerId){
        try {
            PreparedStatement updateAwarded = conn.prepareStatement("UPDATE photographers SET awarded = 1 WHERE photographerId = ?");
            updateAwarded.setInt(1, photographerId);
            updateAwarded.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletePicture(String title){
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM pictures WHERE title = ?");
            ps.setString(1, title);
            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void finish(){
        try {
            if (conn != null){
                conn.close();
                System.out.println("Connection with the Database finished.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
