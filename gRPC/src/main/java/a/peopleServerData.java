package a;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by chien on 6/20/2017.
 */
public class peopleServerData {
    private static  final Logger logger = Logger.getLogger(peopleServerData.class.getName());
    public static URL getDefaultFeaturesFile(){
        return peopleServer.class.getResource("peopleData.json");
    }
    public static List<info> parseInfo(URL file) throws IOException{
//        InputStream input = file.openStream();
        InputStream input = new FileInputStream("C:\\Users\\chien\\IdeaProjects\\gRPC\\src\\main\\java\\a\\peopleData.json");
        try{
            Reader reader = new InputStreamReader(input);
            try{
                infoData.Builder database = infoData.newBuilder();
                try{
                    JsonFormat.parser().merge(reader, database);
                }catch (InvalidProtocolBufferException e){
                    e.getMessage();
                    logger.info("this");
                }

                return database.getInfoDList();
            }finally {
                reader.close();
            }
        }finally {
            input.close();
        }
    }
    public static boolean exists(info i){
        return i != null && !i.getFullname().isEmpty();
    }
}
