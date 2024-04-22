package Milestones;

public class Photographer {
    private int id;
    private String name;
    private int awarded;

    public Photographer(int id, String name, int awarded) {
        this.id = id;
        this.name = name;
        this.awarded = awarded;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAwarded() {
        return awarded;
    }

    @Override
    public String toString() {
        return "Photographer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", awarded=" + awarded +
                '}';
    }
}
