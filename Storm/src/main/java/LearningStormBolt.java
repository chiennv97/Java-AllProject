import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.IRichSpout;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;

/**
 * Created by chien on 6/23/2017.
 */
public class LearningStormBolt extends BaseBasicBolt {
    private static final long serialVertionUID = 1L;
    public void execute(Tuple input, BasicOutputCollector collector){
        String test = input.getStringByField("site");
        System.out.println("name of input site is: " + test);
    }
    public void declareOutputFields(OutputFieldsDeclarer declarer){
        declarer.declare(new Fields("a"));
    }


}
