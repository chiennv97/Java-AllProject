/**
 * Created by chien on 5/12/2017.
 */
import java.io.*;
public class writeFile {
    public static void main(String[] args)  {
        try {
            Writer writer = new FileWriter("F:\\Chiennv\\KI4\\Thuc tap\\test.txt");
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write("kcj");
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
