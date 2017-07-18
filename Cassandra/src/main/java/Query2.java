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
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.*;
import java.util.concurrent.*;

/**
 * Created by chien on 6/11/2017.
 */
public class Query2 {
    public static void main(String[] args) throws IOException{
        Cluster cluster = null;
        try{
            cluster = Cluster.builder()
                    .addContactPoint("127.0.0.1")
                    .build();
            Session session = cluster.connect("chiennv");
            //load data từ file vào cassandra
            //loadData(session);
            queryFindListIp(session);


        }finally{
            if(cluster != null) cluster.close();
        }
    }
    public static void queryFindListIp(Session session){
        Scanner in = new Scanner(System.in);
        System.out.println("typing guid");
        String guid = in.nextLine();
        String query = "select ip from test2 where guid = "+ guid;
        ResultSet rs = session.execute(query);

        //tạo 1 hashmap để lưu danh sách ip cùng số lần xuất hiện
        HashMap<Long,Integer> listIP = new HashMap<Long,Integer>();
        if(rs != null){
            for(Row row:rs){
                long ip = row.getLong("ip");
                if(listIP.containsKey(ip)){
                    int value =  listIP.get(ip) + 1;
                    listIP.put(ip, value);
                }else{
                    listIP.put(ip, 1);
                }
            }

            // sắp xếp theo thứ tự xuất hiện nhiều nhất
            HashMap sortListIP = sortByValues(listIP);
            Set set1 = sortListIP.entrySet();
            Iterator iterator1 = set1.iterator();
            while (iterator1.hasNext()){
                Map.Entry me  = (Map.Entry)iterator1.next();
                System.out.println("IP: "+ me.getKey() + " Count:" + me.getValue());
            }
//            for(Map.Entry m : sortListIP.entrySet()){
//                System.out.println(m.getKey()+" "+m.getValue());
//            }
//            for(Map.Entry map : sortListIP.entrySet()){
//                System.out.println(map.getKey()+" "+map.getValue());
//            }
        }else{
            System.out.println("no result");
        }
    }
    private static HashMap sortByValues(HashMap map) {
        List list = new LinkedList(map.entrySet());

        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue())
                            .compareTo(((Map.Entry) (o1)).getValue());
            }
        });

        HashMap sortedHashMap = new HashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
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
                        QueryBuilder.insertInto("test2")
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
