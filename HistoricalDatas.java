import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.PrintWriter;

//Contains the simulation data.

public class HistoricalDatas {
    
    private FileWriter writer;


    public void generateData(ArrayList<String> results) { //writes one simulated round to a file. We recommend the CSV format
        try {
            this.writer = new FileWriter("historicaldata.csv", true);
            for(String name : results) {
                writer.write(name + ",");
            }
            writer.write("\r\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }

    public ArrayList<String[]> load() { //loads the content of an instance of a HistoricalDatas and returns it
        ArrayList<String[]> historicals = new ArrayList<String[]>();
        try {
            File file = new File("historicaldata.csv");
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                int arrSize = line.split(",").length;
                String[] nameList = new String[arrSize];           
                nameList = (line.split(","));          
                historicals.add(nameList);
            }
            fileReader.close();       
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        return historicals;
    }

    public void deleteLog() {
        File f = new File("historicaldata.csv");
        f.delete();
    } 
}