import java.io.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by chien on 5/14/2017.
 */
public class Bai3CountWordNew implements Callable<Integer>{
    //khởi tạo 1 map static dùng chung cho các class Bai3CountWordNew
    public static ConcurrentHashMap<String,Integer> m = new ConcurrentHashMap<>();

    String pathInput;

    public Bai3CountWordNew(String pathInput) throws IOException {
        this.pathInput = pathInput;
    }
    @Override
    public Integer call() throws Exception {

        //Đọc file
        FileInputStream in = new FileInputStream(pathInput);

        Reader reader = new InputStreamReader(in, "UTF-8");
        BufferedReader br = new BufferedReader(reader);

        String s = null;
        //HashMap<String,Integer> m = new HashMap<String,Integer>();

        //Đọc từng dòng dữ liệu từ file
        while((s = br.readLine())!=null){
            //tách từng từ cách nhau bởi dấu cách, lưu vào mảng word
            String[] word = s.split("\\s");
            //lọc từng từ
            for(String w: word){

                //trả kết quả lọc vào tempWord
                String tempWord = filterWord(w);
                if(tempWord != null){

                    //nếu từ có trong Map thì tăng value lên
                    if(m.containsKey(tempWord)){
                        int currentValue =  m.get(tempWord);
                        m.put(tempWord, currentValue +1);
                    }
                    //nếu từ không có trong Map thì khởi tạo cặp Key và value = 1
                    else {
                        m.put(tempWord, 1);
                    }
                }
            }
        }

        //Đóng luồng
        br.close();
        return 1;
    }

    //Phương thức get ConcurrentHashMap
    public ConcurrentHashMap<String, Integer> getConcurrentHashMap(){
        return m;
    }

    //Phương thức lọc từ
    public static String filterWord(String s){
        boolean isWord = false;
        String word = "";
        int countDacBiet = 0;
        //Duyệt từng kí tự của từ s từ trái sang phải
        for(int i = 0; i< s.length(); i++){

            if(isWord == false){
                //nếu trong khoảng a - z hoặc 0 - 9 thì thêm vào word
                if(s.charAt(i) >= (int) 'a' && s.charAt(i)<= (int) 'z' || s.charAt(i)>= 48 && s.charAt(i)<=57){
                    word += s.charAt(i);
                    isWord = true;
                }
                //nếu trong khoảng A - Z thì lowCase rồi thêm vào word
                if(s.charAt(i) >= (int) 'A' && s.charAt(i)<= (int) 'Z' ){
                    int temp = (int) s.charAt(i) + (int) 'a' - (int) 'A';
                    word += (char) temp;
                    isWord = true;
                }


            }else{//nếu đã có 1 kí tự chữ cái hoặc chữ số xuất hiện trong word thì thêm tất cả các kí tự sau nó vào word

                //nếu trong khoảng A - Z thì lowCase rồi thêm vào word
                if(s.charAt(i) >= (int) 'A' && s.charAt(i)<= (int) 'Z' ){
                    int temp = (int) s.charAt(i) + (int) 'a' - (int) 'A';
                    word += (char) temp;
                }else{
                    word += s.charAt(i);
                }

            }
            //đặc biệt
            if(s.charAt(i) == '('){
                countDacBiet++;
            }

        }

        //nếu word rỗng thì s không phải là 1 từ(có chứa chữ cái hoặc số), nên bỏ qua
        if(word == ""){
            return null;
        }

        //Duyệt từng kí tự của từ word từ phải sang trái
        //Bao giờ gặp kí tự chữ cái hoặc số thì dừng lại, trả về word cần tìm
        boolean end = false;
        int length = word.length();

        while (end == false){
            length --;
            if(word.charAt(length)>= (int) 'a' && word.charAt(length)<= (int) 'z'|| word.charAt(length)>= 48 && word.charAt(length)<=57){
                word = word.substring(0,length+1);
                end = true;
            }
            //trường hợp đặc biệt: "501(c)(3)"
            if(word.charAt(length) == ')' && s.charAt(0) != '(' && countDacBiet !=0){
                word = word.substring(0,length+1);
                end = true;
            }
        }
        return word;
    }


}
