import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;


import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by chien on 6/23/2017.
 */
public class SentenceSpout extends BaseRichSpout {
    private SpoutOutputCollector collector;
    private String[] sentences = {
      "con song dai hoc", "nhu long ne ha", "no cam pu te", "ko ni chi wa"
    };
    private int index = 0;
    public  void declareOutputFields(OutputFieldsDeclarer declarer){
        declarer.declare(new Fields("sentence"));
    }
    public void open(Map config, TopologyContext context, SpoutOutputCollector collector){
        this.collector = collector;
    }
    public void nextTuple(){
        this.collector.emit(new Values(sentences[index]));
        index++;
        if(index>=sentences.length){
            index =0;
        }
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
