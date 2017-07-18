/**
 * Created by chien on 5/12/2017.
 */
import java.util.*;
public class TestTryCatch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try{
            int a = in.nextInt();
            System.out.println("ok");
        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        finally{
            System.out.println("Done");
        }

    }
}
