import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;

public class Menu {

    public void showMenu(Statistics actualStats, Kennel aranypatko, HashMap<String, int[]> stats, HashMap<String, Float> average, HashMap<String, Float> avgPercent, ArrayList<String> horsesList, Race race) throws Exception {

        AverageOfMatches avg = new AverageOfMatches();

       
                int chosen;
                while(true) {
                show();
                System.out.println(" ");
                Scanner reader = new Scanner(System.in);
                System.out.println("Your choice: ");
                chosen = Integer.parseInt(reader.nextLine());

                System.out.println("");
                String monthString;
                switch (chosen) {
                case 1: avg.bestBet(actualStats, aranypatko);
                        break;
                case 2: avg.printOrderedHashMap(actualStats.getPercentMap(), "%");
                        break;
                case 3: avg.printOrderedHashMap(actualStats.getAvgMap(), " average placement");
                        break;
                case 4: avg.statistic(stats);
                        break;
                case 5: avg.bet(horsesList, aranypatko, race);
                        break;
                case 0: System.exit(0); 
                default: monthString = "Invalid number";
                        System.out.println(monthString);
                        break;
                }
        }
      
}
        public void show() {
                String[] options = {"Best bet", "Average of matches won for all horses", "Average placement of every horse", "Statistics for every horse", "Betting simulation", "Exit"};
                System.out.println("  ");
                for (int i = 0; i < options.length - 1; i++ ) {
                    int num = i + 1;
                    System.out.println(num + ". " + options[i]);
                }
                System.out.println(0 + ". " + options[options.length-1]);
        }
        
}