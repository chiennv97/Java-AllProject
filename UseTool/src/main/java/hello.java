import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;


public class hello {
    final static Logger logger = LoggerFactory.getLogger(hello.class);
    public static void main(String[] args) throws InterruptedException, IOException {
        int NumUserOld = 0;
        int NumUserNew;

        int count = 0;
        while (true){
            NumUserNew = getNumberUser();
            if((NumUserNew - NumUserOld) > 3*NumUserOld/100){
                logger.info(String.valueOf(NumUserNew));
                count =0;
                NumUserOld = NumUserNew;
            }else{
                count++;
            }
            if(count == 6){
                logger.debug(String.valueOf(NumUserNew));
                NumUserOld = NumUserNew;
                count =0;
            }
            Thread.sleep(100);
        }


    }

    public static int getNumberUser() throws IOException {
        String s = "http://news.admicro.vn:10002/api/realtime?domain=kenh14.vn";
        URL url = new URL(s);
        //Đọc
        Scanner scan = new Scanner(url.openStream());
        String str = new String();
        while (scan.hasNext()){
            str += scan.nextLine();
        }
        scan.close();

        JSONObject obj = new JSONObject(str);
        return (int) obj.getInt("user");
    }
}