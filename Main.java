
/* Starts the application. Able to
 configure the round of the simulations to run by taking an argument from the command line.
*/
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


import java.io.File;

public class Main {
    
    public static void main(String[] args) throws Exception{
        
        Kennel aranypatko = new Kennel();
        HorseRead ourhorses = new HorseRead();
        aranypatko = ourhorses.horseread();
        Race verseny = new Race(aranypatko);
        HistoricalDatas datalizer = new HistoricalDatas();
        Start begin = new Start();
        Statistics actualStats = new Statistics();

        datalizer.deleteLog();
        System.out.println("");
        HashMap<String, int[]> stats = actualStats.Stats1(begin.generateHistoricalDatas(verseny, datalizer, 200), aranypatko);
        HashMap<String, Float> average = actualStats.average();
        HashMap<String, Float> avgPercent = actualStats.averagePercent();
        ArrayList<String> horsesList = verseny.getWhichPlace();
        //Menu menu1 = new Menu();
        //menu1.showMenu(actualStats, aranypatko, stats, average, avgPercent, horsesList);
        AverageOfMatches avg = new AverageOfMatches();
        avg.printOrderedHashMap(actualStats.getPercentMap(), "%");
                  
        //Display sd = new Display();
        //sd.display(aranypatko, verseny);
        Menu menu1 = new Menu();
        menu1.showMenu(actualStats, aranypatko, stats, average, avgPercent, horsesList, verseny);

                  
        
    }   
}