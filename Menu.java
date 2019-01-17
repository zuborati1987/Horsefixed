import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;

public class Menu {

    public void showMenu(Statistics actualStats, Kennel aranypatko, HashMap<String, int[]> stats, HashMap<String, Float> average, HashMap<String, Float> avgPercent, ArrayList<String> horsesList) {

        AverageOfMatches avg = new AverageOfMatches();

       
                int choosen;
                show();
                System.out.println(" ");
                Scanner reader = new Scanner(System.in);
                System.out.println("Choose from the numbers: ");
                choosen = Integer.parseInt(reader.nextLine());


                String monthString;
                switch (choosen) {
                case 1: avg.average(average);
                        break;
                case 2: avg.averagePercantage(avgPercent);
                        break;
                case 3: avg.bestBet(actualStats, aranypatko);
                        break;
                case 4: avg.bet(horsesList);
                        break;
                case 5: avg.statistic(stats);
                        break;
                case 0: System.exit(0); 
                default: monthString = "Invalid HORSEEEE-chan";
                        break;
                }
                //System.out.println(monthString);
      
}
        public void show() {
                String[] options = {"Average of matches won for all horses", "Average placement of every horse", "Best bet", "Betting simulation", "Statistics for every horse"};
                System.out.println("  ");
                for (int i = 0; i < options.length; i++ ) {
                    int num = i + 1;
                    System.out.println(num + ". " + options[i]);
                }
        }
        
}