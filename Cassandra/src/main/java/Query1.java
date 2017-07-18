/**
 * Created by chien on 6/8/2017.
 */
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.BuiltStatement;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import static com.datastax.driver.core.querybuilder.QueryBuilder.eq;
import java.io.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.lang.*;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.*;

public class Query1 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        Cluster cluster  = null;
        try {
                  cluster = Cluster.builder()
                          .addContactPoint("127.0.0.1")
                          .build();

                  Session session = cluster.connect("chiennv");
                  //load data từ file vào cassandra
                  //loadData(session);


                  System.out.println("typing guid");
                  String guid = in.nextLine();
                  System.out.println("typing date, eg:2016-10-10");
                  String date = in.nextLine();
                  queryUrlByGuidDate(session, guid, date);
                  //Liệt kê các url đã truy cập trong ngày của một guid

          } finally {
              if (cluster != null) cluster.close();
          }

    }
    public static void queryUrlByGuidDate(Session session, String guid, String date){
        long testGuid = Long.parseLong(guid);
        String testDate = date;
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        long timeADay, timeDate, timeDate2;
        try {
            Date date1 = f.parse("2016-10-06");
            Date date2 = f.parse("2016-10-07");
            timeADay = date2.getTime() - date1.getTime();

            Date date3 = f.parse(testDate);
            timeDate = date3.getTime();
            timeDate2 = timeDate + timeADay;
            String query = "select referer from test1 where guid = "+testGuid+ "and timecreate > "+timeDate +"and timecreate < " + timeDate2;
            ResultSet rs = session.execute(query);
            if(rs == null){
                System.out.println("no result");
            }else{
                for(Row row:rs){
                    System.out.println(row.getString("referer"));
                }
            }
        }catch (ParseException e){
            e.printStackTrace();
        }
    }
    public static void loadData(Session session) throws IOException {
        //Đọc file
        FileInputStream in = new FileInputStream("/home/chiennv/cassandra/adv1475687109957.dat");
        Reader reader = new InputStreamReader(in, "UTF-8");
        BufferedReader  br = new BufferedReader(reader);
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
                        QueryBuilder.insertInto("test1")
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
