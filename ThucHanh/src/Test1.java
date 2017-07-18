/**
 * Created by chien on 5/12/2017.
 */
import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) {
        String s = "(801)";
        System.out.println(filterWord(s));

    }
    //Phương thức lọc từ
    public static String filterWord(String s){
        boolean isWord = false;
        String word = "";

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
            if(word.charAt(length) == ')' && s.charAt(0) != '('){
                word = word.substring(0,length+1);
                end = true;
            }
        }
        return word;
    }


}
