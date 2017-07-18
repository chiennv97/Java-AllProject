package a;

import io.grpc.ManagedChannel;
import a.peopleGrpc.peopleBlockingStub;
import a.peopleGrpc.peopleStub;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by chien on 6/21/2017.
 */
public class peopleClient {
    private static final Logger logger = Logger.getLogger(peopleClient.class.getName());
    private final ManagedChannel channel;
    private final peopleBlockingStub blockingStub;
    private final peopleStub asyncStub;
    public peopleClient(String host, int port){
        this(ManagedChannelBuilder.forAddress(host,port).usePlaintext(true));
    }
    public peopleClient(ManagedChannelBuilder<?> channelBuilder){
        channel = channelBuilder.build();
        blockingStub = peopleGrpc.newBlockingStub(channel);
        asyncStub = peopleGrpc.newStub(channel);

    }
    public void shutdown() throws InterruptedException{
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
    public void GetPeople(String s){
        name n = name.newBuilder().setN(s).build();
        info info1;
        try{
            info1 = blockingStub.getPeople(n);
            if(peopleServerData.exists(info1)){
                logger.info(info1.getFullname() + " " + info1.getAge());

            }else{
                logger.info("nothing");

            }
        }catch (StatusRuntimeException e){
            logger.warning("RPC failed: {0}" + e.getStatus());
        }

    }
    public static void main(String[] args) throws InterruptedException{
        peopleClient client = new peopleClient("localhost", 8980);
        try{
            client.GetPeople("nam");
        }finally {
            client.shutdown();
        }
    }
}
