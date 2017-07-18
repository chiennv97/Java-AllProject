import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Timestamp;
import java.util.Date;


/**
 * Created by chien on 5/19/2017.
 */
public class getData {
    public static void main(String[] args) throws IOException, InterruptedException {
         Document doc = Jsoup.connect("http://dantri.com.vn").get();

        String data = doc.html();

        //Thời gian lấy dữ liệu
        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);

        //Lọc tên
        String name = "";
        int count =0;
        for(int j =0; j < ts.toString().length(); j++){
            if(ts.toString().charAt(j) != ':'){
                name += ts.toString().charAt(j);
            }else{
                count++;
                if(count == 1){
                    name += 'h';
                }
                if(count == 2){
                    count =0;
                    name += 'm';
                }
            }
        }
        name +="s.txt";

        //Ghi kết quả ra file
        Writer w = new FileWriter(name);
        BufferedWriter bw=new BufferedWriter(w);
        bw.write(data);
        bw.close();

    }
}
