
/*It is responsible for evaluating 
the generated historical dataset that you have to generate in generateHistoricalDatas.
*/


public class DataEvaluator {
    private HistoricalDatas historicalDatas;
    private Logger logger;

    public DataEvaluator(HistoricalDatas historicalDatas, Logger logger) {
        this.historicalDatas = historicalDatas;
        this.logger = logger;
    }

    //public Result run() {}//it returns a Result instance to inform us about the end of the playing and it stores the evaluated result

}