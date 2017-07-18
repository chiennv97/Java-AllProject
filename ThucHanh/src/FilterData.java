import java.io.*;

/**
 * Created by chien on 6/7/2017.
 */
public class FilterData {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        //Đọc file
        FileInputStream in = new FileInputStream("F:\\Chiennv\\KI4\\Thuc tap\\01.txt");

        Reader reader = new InputStreamReader(in, "UTF-8");
        BufferedReader br = new BufferedReader(reader);
    }
}
