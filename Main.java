
/* Starts the application. Able to
 configure the round of the simulations to run by taking an argument from the command line.
*/
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
        //System.out.println("");
        actualStats.Stats1(begin.generateHistoricalDatas(verseny, datalizer, 200), aranypatko);
        actualStats.average();
        actualStats.averagePercent();
        /*for(String key : actualStats.findMostWins().keySet()) {
            System.out.println("The best bet is: ");
            System.out.print(key + ": ");
            System.out.print(actualStats.findMostWins().get(key) + "% of matches won from "); 
            for(Horse horse : aranypatko.getHorseList()) {
                if(horse.getName().equals(key)) {
                    System.out.print(horse.getNumRaces() + " matches, with a placement average of ");
                }
            }
            System.out.println(actualStats.findBestAvg(actualStats.findMostWins()) + ".");
        }*/
                  
        Display sd = new Display();
        sd.display(aranypatko, verseny);
        //sd.asciiHorsePorn();
        //sd.asciiHorseShit();
    }   
}