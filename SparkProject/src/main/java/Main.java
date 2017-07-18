/**
 * Created by chien on 5/19/2017.
 */
import spark.Request;
import spark.Response;

import java.util.ArrayList;

import static  spark.Spark.*;
public class Main {
    public static void main(String[] args) {
        //Định tuyến và lấy giá trị của n tại đường dẫn
        get("/prime", (Request req, Response res) -> {
            String number = req.queryParams("n");
            //bắt lỗi không phải là số
            try{
                int n = Integer.parseInt(number);
                if(n<=1){
                    return "null";
                }else{
                    return listPrime(n);
                }
            }catch (Exception e){
                return "Not is number";
            }


        });
//        ArrayList a = listPrime(100);
//        for(int i=0; i<a.size();i++){
//            System.out.println(a.get(i));
//        }
        // nếu <=1
    }
    //Trả lại danh sách các số nguyên tố từ 1 đnến n

    public static ArrayList listPrime(int n){
        ArrayList list = new ArrayList();

        for(int i =2; i<=n ;i++){
            if(isPrime(i) == true){
                list.add(i);
            }
        }
        return list;
    }
    //Trừ 2, 3 thì các số nguyên tố khác đều có dạng 6K+1 hoặc 6K-1
    //kiểm tra số n có phải số nguyên tố ko thì kiểm tra từ 2 -> căn của n
    public static boolean isPrime(int n){
        if(n ==2 || n ==3){
            return true;
        }
        //nếu có dạng 6K+2 hoặc 6k-2, 6K+3 hoặc 6K-3 thì trả về false
        if(n%2 ==0 || n%3 ==0){
            return false;
        }
        //kiểm tra trong khoảng từ [5;sqrtN]
        double sqrtN = Math.sqrt(n);
        int k =-1;
        while (k<=sqrtN){
            k+=6;
            if(n%(k)==0 || n%(k+2)==0){
                break;
            }
        }

        return k>sqrtN;
    }
}
