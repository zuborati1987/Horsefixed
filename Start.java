import java.util.ArrayList;

public class Start {

    public ArrayList<String[]> generateHistoricalDatas(Race verseny, HistoricalDatas datalizer, int round) { //returns a HistoricalDatas instance that contains the simulation result          
        for(int i = 0; i < round; i++) {
            datalizer.generateData(verseny.startRace());
        }
        return datalizer.load();
    }
}