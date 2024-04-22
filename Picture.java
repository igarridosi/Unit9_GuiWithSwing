package Milestones;

import org.jdesktop.swingx.JXDatePicker;

public class Picture {
    private int pictureId;
    private String title;
    private JXDatePicker date;
    private String file;
    private int visits;
    private int photographerId;

    public Picture(int pictureId, String title, JXDatePicker date, String file, int visits, int photographerId) {
        this.pictureId = pictureId;
        this.title = title;
        this.date = date;
        this.file = file;
        this.visits = visits;
        this.photographerId = photographerId;
    }

    public int getPictureId() {
        return pictureId;
    }

    public String getTitle() {
        return title;
    }

    public JXDatePicker getDate() {
        return date;
    }

    public String getFile() {
        return file;
    }

    public int getVisits() {
        return visits;
    }

    public int getPhotographerId() {
        return photographerId;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "pictureId=" + pictureId +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", file='" + file + '\'' +
                ", visits=" + visits +
                ", photographerId=" + photographerId +
                '}';
    }
}
