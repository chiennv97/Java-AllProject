import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.BuiltStatement;
import com.datastax.driver.core.querybuilder.QueryBuilder;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by chien on 6/12/2017.
 */
public class Query5 {
    public static void main(String[] args) throws IOException{
        //Tính thời gian
        long startTime = System.currentTimeMillis();
        Cluster cluster = null;
        try{
            cluster = Cluster.builder()
                    .addContactPoint("127.0.0.1")
                    .build();
            Session session = cluster.connect("chiennv");
            //load data từ file vào cassandra
            //loadData(session);

            //query
            query(session);


        }finally{
            if(cluster != null) cluster.close();
        }
        //Tinh thoi gian chay
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Time running: " + totalTime + " millisecond");
    }
    public static void query(Session session){
        long thirtyMinute = 1800000; //miliseconds
        String query = "select guid from test5 where timesub < "+ thirtyMinute + " allow filtering";
        ResultSet rs = session.execute(query);
        HashSet listGuid = new HashSet();
        if(rs != null){
            for(Row row:rs){
                long guid = row.getLong("guid");
                if(listGuid.contains(guid) == false){
                    listGuid.add(guid);
                }
            }
            System.out.println("count guid have timecreate - timecookie < 30 minutes :" + listGuid.size());

        }else{
            System.out.println("no result");
        }
        //In kết quả ra màn hình

    }
    public static void loadData(Session session) throws IOException {
        //Đọc file
        FileInputStream in = new FileInputStream("/home/chiennv/cassandra/adv1475687109957.dat");
        Reader reader = new InputStreamReader(in, "UTF-8");
        BufferedReader br = new BufferedReader(reader);
        String s = null;
        while((s = br.readLine())!=null) {

            String[] word = s.split("\t");
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long timeCreate, timeCookie;
            try {
                Date date1 = f.parse(word[0]);
                timeCreate = date1.getTime();
                Date date2 = f.parse(word[1]);
                timeCookie = date2.getTime();

                BuiltStatement InsertBuilt =
                        QueryBuilder.insertInto("test5")
                                .value("timeCreate", timeCreate)
                                .value("cookieCreate", timeCookie)
                                .value("browserCode", Integer.parseInt(word[2]))
                                .value("browserVer", word[3])
                                .value("osCode", Integer.parseInt(word[4]))
                                .value("osVer", word[5])
                                .value("ip", Long.parseLong(word[6]))
                                .value("locId", Integer.parseInt(word[7]))
                                .value("domain", word[8])
                                .value("siteId", word[9])
                                .value("cId", Integer.parseInt(word[10]))
                                .value("path", word[11])
                                .value("referer", word[12])
                                .value("guid", Long.parseLong(word[13]))
                                .value("flashVersion", word[14])
                                .value("jre", word[15])
                                .value("sr", word[16])
                                .value("sc", word[17])
                                .value("geographic", Integer.parseInt(word[18]))
                                .value("timeSub", timeCreate-timeCookie);


                ResultSet InsertResult = session.execute(InsertBuilt);

            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        br.close();
    }
}
