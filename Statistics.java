import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;

/*Stores statistical data about the simulation: 
how many number of simulations were run, how many data points, 
how long it take to run all the simulations, winning/losing percentages, etc. 
It depends on the selected game.*/
import java.util.ArrayList;;
public class Statistics {
    private HashMap<String, int[]> stats;
    private HashMap<String, Float> avgMap;
    private HashMap<String, Float> percentMap;

    public HashMap<String, int[]> Stats1(ArrayList<String[]> results, Kennel kennel) {
    
        stats = new HashMap <String, int[]>();
        Kennel horseNames = kennel;
        ArrayList<Horse> horseList = horseNames.getHorseList();

        for(Horse horse : horseList) {
            int[] temp = {0, 0, 0, 0, 0};
            stats.put(horse.getName(), temp);
        }

        for (String[] oneRace : results) {
            for (int j = 0; j < 5; j++) {
               int[] buffer = stats.get(oneRace[j]);
               buffer[j]++;
            }
        }
        /*for(Map.Entry<String, int[]> entry : stats.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print(": ");
            for(int num : entry.getValue()) {
                System.out.print(num);
                System.out.print(", ");
            }
            System.out.println("");
            
        }*/
        /*for(Horse horse : horseList) {
            System.out.print(horse.getName());
            System.out.print(": ");
            System.out.println(horse.getNumRaces());
        }*/
        return stats;
    }

    public HashMap<String, Float> average() {
        avgMap = new HashMap<String, Float>();
        for(Map.Entry<String, int[]> entry : stats.entrySet()) {
            int numSum = 0;
            int timesSum = 0;
            for(int i = 0; i < 5; i++) {
                numSum += entry.getValue()[i] * (i + 1);
                timesSum += entry.getValue()[i];
                
            }
            float horseAvg = numSum / (float) timesSum;
            avgMap.put(entry.getKey(), horseAvg);
            }
            /*for(String name : avgMap.keySet()) {
                System.out.print(name);
                System.out.print(": ");
                System.out.println(avgMap.get(name));
            }*/
            return avgMap;
        }

        public HashMap<String, Float> averagePercent() {
            percentMap = new HashMap<String, Float>();
            for(Map.Entry<String, int[]> entry : stats.entrySet()) {
                int numSum = entry.getValue()[0];
                int timesSum = 0;
                for(int i = 0; i < 5; i++) {                  
                    timesSum += entry.getValue()[i];        
            }
            float horseAvg = (numSum / (float) timesSum) * 100;
            percentMap.put(entry.getKey(), horseAvg);
            }
            /*for(String name : percentMap.keySet()) {
                System.out.print(name);
                System.out.print(": ");
                System.out.println(percentMap.get(name) + "%");
            }*/
            return percentMap;
        }

        public HashMap<String, Float> findMostWins() {
            HashMap<String, Float> result = new HashMap<String, Float>();
            Float bestest = 0.0f;
            String fastest = "";
            for(Map.Entry<String, Float> entry : percentMap.entrySet()) {
                if(entry.getValue() > bestest) {
                    bestest = entry.getValue();
                }
            }
            for(Map.Entry<String, Float> entry : percentMap.entrySet()) {
                if(entry.getValue() == bestest) {
                    fastest = entry.getKey();
                }
            }
            result.put(fastest, bestest);
            return result;
        }

        public Float findBestAvg(HashMap<String, Float> mapMap) {
            Float bestAvg = 0.0f;
            for(String name : avgMap.keySet()) {
                for(String otherName : mapMap.keySet()) {
                    if(name.equals(otherName)) {
                        bestAvg = avgMap.get(name);
                    }
                }
            }
            return bestAvg;
        }
        
        public HashMap<String, Float> getAvgMap() {
            return this.avgMap;
        }

        public HashMap<String, Float> getPercentMap() {
            return this.percentMap;
        }
    }
    

