import java.util.*;
import java.io.*;


public class HorseRead{

    public Kennel horseread()throws Exception{
        Kennel aranypatko = new Kennel();
        File file = new File("horses.csv");
        Scanner fileReader = new Scanner(file);
        while(fileReader.hasNextLine()){
            String line = fileReader.nextLine();
            StringTokenizer st = new StringTokenizer(line);
            while(st.hasMoreTokens()){
                aranypatko.addHorse(new Horse(st.nextToken(";"), Integer.parseInt(st.nextToken(";")), Integer.parseInt(st.nextToken(";")), Integer.parseInt(st.nextToken(";"))));
            }
        }
        fileReader.close();
        return aranypatko;
    }
}
    



