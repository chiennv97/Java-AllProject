/**
 * Created by chien on 5/11/2017.
 */
import java.io.*;
public class WriteString {
    public static void main(String[] args) {
        try{
            File f1 = new File("F:\\new.txt");
            String str = "so";
            FileWriter fw = new FileWriter(f1);
            fw.write(str);
            fw.close();

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
