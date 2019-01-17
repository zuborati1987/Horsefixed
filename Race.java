import java.util.LinkedHashMap;
import java.util.Random;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

public class Race {
    private Kennel kennel;
    private LinkedHashMap<String, Double> resultMap;
    private ArrayList<Horse> speedResults;
    private ArrayList<String> whichPlace;
    ArrayList<Integer> goToArr;

    public Race(Kennel kennel) {
        this.kennel = kennel;
    }

    public ArrayList<String> startRace() {
        goToArr = new ArrayList<Integer>();
        Random randomizer = new Random();
        HashSet<Integer> goToRace = new HashSet<Integer>();
        while (goToRace.size() != 5) {
            int temporal = randomizer.nextInt(20);
            goToRace.add(temporal);
        }
        for (int num : goToRace) {
            goToArr.add(num);
        }
        this.resultMap = new LinkedHashMap<String, Double>();
        this.speedResults = new ArrayList<Horse>();
        this.whichPlace = new ArrayList<String>();

        for (int j = 0; j < 5; j++) {
            this.kennel.getHorseList().get(goToArr.get(j)).goRace(); // sends horses to race
            Horse horse = this.kennel.getHorseList().get(goToArr.get(j));
            horse.countSpeed();
            this.speedResults.add(horse);
        }
        for (Horse horse : this.kennel.getHorseList()) {
            if (!horse.getOnRace()) {
                horse.goRest();
            }
        }

        Collections.sort(this.speedResults, Collections.reverseOrder()); // sorts the array


        for (Horse horse : speedResults) {
            whichPlace.add(horse.getName());
        }
        return whichPlace;
    }

    public ArrayList<Integer> getGoToArr() {
        return this.goToArr;
    }

    public ArrayList<String> getWhichPlace() {
        return this.whichPlace;
    }
}
