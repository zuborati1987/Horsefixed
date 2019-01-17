import java.util.ArrayList;

public class Kennel {
    private ArrayList<Horse> horseList;

    public Kennel() {
        this.horseList = new ArrayList<Horse>();
    }

    public void addHorse(Horse horse) {
        this.horseList.add(horse);
    }

    public ArrayList<Horse> getHorseList() {
        return this.horseList;
    }
}