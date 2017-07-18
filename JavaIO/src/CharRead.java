/**
 * Created by chien on 5/11/2017.
 */
import java.io.*;
public class CharRead {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char c = (char)br.read();
        System.out.println(c);
    }
}
