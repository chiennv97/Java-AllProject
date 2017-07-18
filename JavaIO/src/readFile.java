/**
 * Created by chien on 5/11/2017.
 */
import java.io.*;
public class readFile {
    public static void main(String[] args) {
        try{
           File f1 =  new File("F:\\Chiennv\\KI4\\Thuc tap\\demoTex.txt");
            BufferedReader br = new BufferedReader(new FileReader(f1));
            String str;
            while((str=br.readLine())!=null){
                System.out.println(str);
            }

            br.close();


        }

        catch(IOException e){
            e.printStackTrace();
        }


    }

}
