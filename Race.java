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

    public /* LinkedHashMap<String, Double> */ ArrayList<String> startRace() {
        goToArr = new ArrayList<Integer>();
        Random randomizer = new Random();
        HashSet<Integer> goToRace = new HashSet<Integer>();
        // for(int i = goToRace.size(); i < 5; i++) {
        while (goToRace.size() != 5) {
            int temporal = randomizer.nextInt(20);
            /*
             * while(goToRace.contains(temporal)) { temporal = randomizer.nextInt(20); }
             */
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
            // this.kennel.getHorseList().get(i).goRest(); //sends the other horses to rest
            if (!horse.getOnRace()) {
                horse.goRest();
            }
        }

        Collections.sort(this.speedResults, Collections.reverseOrder()); // sorts the array

        /*
         * for(Horse horse : this.kennel.getHorseList()) { for(Horse otherHorse :
         * this.kennel.getHorseList()) { if(horse.getActualSpeed() ==
         * otherHorse.getActualSpeed()) { horse.setActualSpeed(); } } }
         */

        for (Horse horse : speedResults) {
            // resultMap.put(horse.getName(), horse.getActualSpeed());

            whichPlace.add(horse.getName());
        }
        /*
         * for(String horseName : resultMap.keySet()) { System.out.println(horseName +
         * " " + resultMap.get(horseName)); } for(String horseName : whichPlace) {
         * System.out.println(horseName); }
         */
        return whichPlace;
    }

    public ArrayList<Integer> getGoToArr() {
        return this.goToArr;
    }

    public ArrayList<String> getWhichPlace() {
        return this.whichPlace;
    }
}
