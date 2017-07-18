/**
 * Created by chien on 5/11/2017.
 */
import java.io.*;
public class ReadString {
    public static void main(String[] args) throws IOException {
        String text;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        text = br.readLine();
        System.out.println(text);
    }
}
