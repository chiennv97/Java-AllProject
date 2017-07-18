import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chien on 6/9/2017.
 */
public class longtime {
    public static void main(String[] args) {
        long testGuid = Long.parseLong("3901120742885229173");
        String testDate = "2016-10-06";
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        long timeADay, timeDate, timeDate2;
        try {
            Date date1 = f.parse("2016-10-06");
            Date date2 = f.parse("2016-10-07");
            timeADay = date2.getTime() - date1.getTime();
            System.out.println(timeADay);
            Date date3 = f.parse(testDate);
            timeDate = date3.getTime();
            timeDate2 = timeDate + timeADay;
            String query = "select referer from test where guid = '"+testGuid+ "' and timecreate > '"+timeDate +"' and timecreate < '" + timeDate2+"'";
            System.out.println(query);
        }catch (ParseException e){
            e.printStackTrace();
        }
    }
}
