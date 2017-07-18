import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.BuiltStatement;
import com.datastax.driver.core.querybuilder.QueryBuilder;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by chien on 6/9/2017.
 */
public class Query3 {
    public static void main(String[] args) throws IOException {
        Cluster cluster = null;
        try{
            cluster = Cluster.builder()
                    .addContactPoint("127.0.0.1")
                    .build();
            Session session = cluster.connect("chiennv");
            //load data từ file vào cassandra
            //loadData(session);

            //Query Tìm thời gian truy cập gần nhất của một GUID (input: guid=> output: thời gian truy cập gần nhất)
            queryNearlyTimeOfGuid(session);

        }finally{
            if(cluster != null) cluster.close();
        }
    }
    public static void queryNearlyTimeOfGuid(Session session){
        Scanner in = new Scanner(System.in);
        System.out.println("typing guid");
        String guid = in.nextLine();
        String query = "select timecreate from test3 where guid = "+ guid+ " limit 1";
        ResultSet rs = session.execute(query);
        if(rs == null){
            System.out.println("no result");
        }else{
            for(Row row:rs){
                //chuyển định dạng
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = df.format(row.getTimestamp("timecreate"));
                System.out.println(date);
            }
        }
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
                        QueryBuilder.insertInto("test3")
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
                                .value("geographic", Integer.parseInt(word[18]));

                ResultSet InsertResult = session.execute(InsertBuilt);

            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        br.close();
    }
}
