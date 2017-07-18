import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.topology.TopologyBuilder;

/**
 * Created by chien on 6/23/2017.
 */
public class LearningStormTopology {
    public static void main(String[] args) throws AlreadyAliveException, InvalidTopologyException{
        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("LearnStormSpout", new LearnStormSpout(), 2);
//        builder.setSpout("LearningStormBolt", new LearningStormBolt(), 4)
        builder.setBolt("LearningStormBolt", new LearningStormBolt(), 4).shuffleGrouping("LearningStormSpout");
        Config conf = new Config();
        conf.setDebug(true);
        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("LearningStromTopology", conf, builder.createTopology());
        try{
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        cluster.killTopology("LearningStormTopology");
        cluster.shutdown();
    }
}
