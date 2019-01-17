import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class AverageOfMatches {


    public void bestBet(Statistics actualStats, Kennel aranypatko) {
        for(String key : actualStats.findMostWins().keySet()) {
            System.out.println("The best bet is: ");
            System.out.print(key + ": ");
            System.out.print(actualStats.findMostWins().get(key) + "% of matches won from "); 
            for(Horse horse : aranypatko.getHorseList()) {
                if(horse.getName().equals(key)) {
                    System.out.print(horse.getNumRaces() + " matches, with a placement average of ");
                }
            }
            System.out.println(actualStats.findBestAvg(actualStats.findMostWins()) + ".");
        }
    }

    public void statistic(HashMap<String, int[]> stats) {
        for(Map.Entry<String, int[]> entry : stats.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print(": ");
            for(int num : entry.getValue()) {
                System.out.print(num);
                System.out.print(", ");
            }
            System.out.println("");
            
        }
    }
    public void average(HashMap<String, Float> average) {
        for(String name : average.keySet()) {
            System.out.print(name);
            System.out.print(": ");
            System.out.println(average.get(name));
        } 
    }

    public void averagePercantage(HashMap<String, Float> avgPercent) {
        for(String name : avgPercent.keySet()) {
            System.out.print(name);
            System.out.print(": ");
            System.out.println(avgPercent.get(name) + "%");
        }
    }
    public void bet(ArrayList<String> horsesList, Kennel kennel, Race race) throws Exception {
        Display sd = new Display();
        for(int i = 0; i < horsesList.size(); i++) {
            int j = i + 1;
            System.out.println(j + ". " + horsesList.get(i));
        }

        int choosen;
        System.out.println(" ");
        Scanner reader = new Scanner(System.in);
        System.out.println("\n Please bid on a horse: ");
        choosen = Integer.parseInt(reader.nextLine());
        
        Thread.sleep(1000);
        sd.display(kennel, race);
        Thread.sleep(1000);
        System.out.println(horsesList.get(choosen-1));
        if (horsesList.get(0) == horsesList.get(choosen-1)) {
            System.out.println("You won");
            Thread.sleep(2000);
            sd.asciiHorsePorn();
        } else {
            System.out.println("You lost");
            Thread.sleep(2000);
            for(int i = 0; i < 8; i++){
                sd.asciiHorseShit(i);
                Thread.sleep(500);
            }
        }
    }

    public void printOrderedHashMap(HashMap<String, Float> averages, String measurement) {
        ArrayList<Float> sortingTemp = new ArrayList<Float>();
        for(Map.Entry<String, Float> entry : averages.entrySet()) {
            sortingTemp.add(entry.getValue());
        }
        if(measurement.equals("%")) {
            Collections.sort(sortingTemp, Collections.reverseOrder());
        } else {
            Collections.sort(sortingTemp);
        }
        for(Float number : sortingTemp) {
            for(Map.Entry<String, Float> entry : averages.entrySet()) {
                if(number == entry.getValue()) {
                    System.out.println(entry.getKey() + ": " + number + " " + measurement);
                }
            }
        }
    }
}