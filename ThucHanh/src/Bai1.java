/**
 * Created by chien on 5/12/2017.
 */
import java.util.*;
import java.io.*;
public class Bai1 {
    Set day1, day2, tapGiao, tapHop;

    public Bai1(Set d1, Set d2, Set g, Set h){
        //Tính thời gian
        long startTime = System.currentTimeMillis();

        day1 = d1;
        day2 = d2;
        tapGiao = g;
        tapHop = h;

        //Sinh số ngẫu nhiên cho 2 dãy
        genericNumber(day1,day2);

        //Tìm tập giao và tập hợp
        for(Object day : day1){
            if(day2.contains(day)){
                tapGiao.add(day);
            }else{
                //thêm các phần tử chỉ thuộc dãy 1 vào tapHop
                tapHop.add(day);

            }
        }

        //thêm các phần tử dãy 2 vào tapHop để hoàn thành tập hợp
        Iterator it2 = day2.iterator();
        while (it2.hasNext()){
            tapHop.add(it2.next());
        }

        //In kết quả
        printOutPut(day1, "Day 1");
        printOutPut(day2, "Day 2");
        printOutPut(tapGiao, "Tap Giao");
        printOutPut(tapHop, "Tap Hop");

        //Tinh thoi gian chay
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Time running: " + totalTime + " millisecond");
    }

    public static void genericNumber(Set d1, Set d2){
        Random rand = new Random();
        int a = rand.nextInt(11) + 2; //chọn a trong khoảng từ 2 - 10, truyền vào phương thức getRandomBoolean
        Boolean numberCopy; //biến Boolean, quyết định xem dãy 2 có copy phần tử thứ i từ dãy 1 không

        //Sinh số ngẫu nhiên cho 2 dãy
        for(int i =0; i<2000; i++){
            int temp =  rand.nextInt() + 1;
            d1.add(temp);
            numberCopy = getRandomBoolean(a);
            if(numberCopy == true){
                d2.add(temp);
            }else{
                d2.add(rand.nextInt() + 1);
            }
        }
    }


    //trả về true or false, quyết định xem dãy 2 có copy phần tử thứ i từ dãy 1 không
    // a trong khoảng từ 2 đến 10 nên số phần tử trùng sẽ trong khoảng 1/10 - 1/2 (10% - 50%)
    public static boolean getRandomBoolean(int a){
        Random rand = new Random();
        int temp = rand.nextInt(a) + 1;
        if(temp == 1){
            return true;
        }
        return false;
    }

    //In ra màn hình
    public static void printOutPut(Set a, String s){
        System.out.println(s + " co so phan tu la: " + a.size());
        Iterator it = a.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();
        System.out.println();
    }
}
