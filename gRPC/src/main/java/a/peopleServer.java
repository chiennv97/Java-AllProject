package a;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.logging.Logger;


/**
 * Created by chien on 6/20/2017.
 */
public class peopleServer {
    private static  final Logger logger = Logger.getLogger(peopleServer.class.getName());
    private final int port;
    private final Server server;
    public peopleServer(int port) throws IOException {
        this(port, peopleServerData.getDefaultFeaturesFile());
    }
    public peopleServer(int port, URL featurefile) throws IOException{
        this(ServerBuilder.forPort(port), port, peopleServerData.parseInfo(featurefile));
    }
    public peopleServer(ServerBuilder<?> serverBuilder, int port, Collection<info> features) throws IOException {
        this.port = port;
        server = serverBuilder.addService(new peopleService(features)).build();
    }
    public void start() throws IOException {
        server.start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may has been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                peopleServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }
    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
    public static void main(String[] args) throws Exception {
        peopleServer server = new peopleServer(8980);
        server.start();
        server.blockUntilShutdown();
    }

    private static class peopleService extends peopleGrpc.peopleImplBase{
        private final Collection<info> features;
        peopleService(Collection<info> features){
            this.features = features;
        }
        @Override
        public void getPeople(name request, StreamObserver<info> reponseObserver){
            reponseObserver.onNext(checkInfo(request));
            reponseObserver.onCompleted();
        }
        private info checkInfo(name fullname){
            for(info i : features){
                logger.info("+"+i.getFullname()+"+");
                logger.info("+"+fullname.getN()+"+");
                if(i.getFullname().equals(fullname.getN())){
                    return i;
                }
            }
            logger.info("nothing");
            return info.newBuilder().setFullname("").setAge(8).build();
        }
    }



}
