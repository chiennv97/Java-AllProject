import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * Created by chien on 5/14/2017.
 *Các bước làm;
 * Tạo Class Bai3CountWordNew implements Callable:
 * Đếm từ xuất hiện trong file có đường dẫn pathInput sau đó lưu vào ConcurrentHashMap
 *
 * Tạo Class RunBai3:
 * Tạo 1 biến ConcurrentHashMap để lưu kết quả đếm từ của tất cả các luồng
 * Tạo executorService để tạo và quản lý các thread
 * Tạo mảng inputPaths để lưu đường dẫn của các file data
 * Chạy các luồng đếm từ
 * Đợi đến khi callable hoàn thành
 * Tạo luồng ghi file
 * Sắp xếp và ghi ra file top 10 từ xuất hiện nhiều nhất, ít nhất
 * Ghi kết quả ra file
 * Đóng luồng ghi file
 * Tắt executorService
 */
public class RunBai3 {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        //Tính thời gian
        long startTime = System.currentTimeMillis();

        //Chọn ConcurrentHashMap vì nó Thread-safe giống HashTable
        ConcurrentHashMap<String,Integer> m = new ConcurrentHashMap<>();

        ExecutorService executorService = Executors.newCachedThreadPool();

        //Đường dẫn của file data
        String[] inputPaths = {"data\\01.txt", "data\\521-0.txt", "data\\2600-0.txt", "data\\3600-0.txt", "data\\5000-8.txt" , "data\\53086-0 - Copy (2).txt",
                                "data\\53086-0 - Copy (3).txt", "data\\53086-0 - Copy.txt", "data\\53086-0.txt" , "data\\53097-0.txt", "data\\pg132 - Copy (2).txt", "data\\pg132 - Copy (3).txt", "data\\pg132 - Copy (4).txt"
                                , "data\\pg132 - Copy.txt" , "data\\pg132.txt", "data\\pg174 - Copy - Copy (2).txt", "data\\pg174 - Copy - Copy (3).txt", "data\\pg174 - Copy - Copy (4).txt", "data\\pg174 - Copy - Copy.txt", "data\\pg174 - Copy (2).txt", "data\\pg174 - Copy (3).txt"
                                 , "data\\pg174 - Copy (4).txt" , "data\\pg174 - Copy (5).txt", "data\\pg174 - Copy.txt", "data\\pg174.txt", "data\\pg345 - Copy - Copy (2).txt", "data\\pg345 - Copy - Copy (3).txt"
                                 , "data\\pg345 - Copy - Copy (4).txt", "data\\pg345 - Copy - Copy.txt", "data\\pg345 - Copy (2).txt", "data\\pg345 - Copy (3).txt", "data\\pg345 - Copy (4).txt", "data\\pg345 - Copy (5).txt", "data\\pg345 - Copy.txt"
                                  , "data\\pg345.txt", "data\\pg972 - Copy - Copy (2).txt", "data\\pg972 - Copy - Copy (3).txt", "data\\pg972 - Copy - Copy (4).txt", "data\\pg972 - Copy - Copy.txt", "data\\pg972 - Copy.txt", "data\\pg972.txt"
                                  , "data\\pg1661 - Copy.txt", "data\\pg1661.txt", "data\\pg2701 - Copy.txt", "data\\pg2701.txt", "data\\pg10422 - Copy.txt", "data\\pg10422.txt", "data\\pg10551 - Copy.txt"
                                  , "data\\pg10551.txt", "data\\pg18970 - Copy.txt", "data\\pg18970.txt" , "data\\pg20417 - Copy.txt" , "data\\pg20417.txt", "data\\pg30254.txt", "data\\pg30360.txt", "data\\pg53085.txt"};
        int numFile = 56;
        Future<Integer>[] future = new Future[numFile];
        Integer[] resultFuture = new Integer[numFile];

        //Tạo các luồng đếm từ và put vào ConcurrentHashMap
        Callable<Integer> task;
        int countFuture = 0;
        for(String s: inputPaths){
             task = new Bai3CountWordNew(s);
            future[countFuture++]= executorService.submit(task);
        }

        //đợi đến khi hàm callable hoàn thành
        for(int i=0; i<numFile; i++){
            resultFuture[i] = future[i].get();
        }

        m = Bai3CountWordNew.m;

        //Tạo luồng ghi file
        Writer w = new FileWriter("data\\output3.txt");
        BufferedWriter bw=new BufferedWriter(w);

        //Sắp xếp và ghi vào file

        bw.write("Top 10 từ xuất hiện nhiều nhất: ");
        findMaxAndMin(m,"Max",bw);

        bw.write("Top 10 từ xuất hiện ít nhất: ");
        findMaxAndMin(m,"Min",bw);

        //Ghi kết quả ra file
        for(Map.Entry map : m.entrySet()){
            bw.write(map.getKey()+" "+map.getValue());
            bw.newLine();
        }


        //Đóng luồng
        bw.close();

        executorService.shutdown();

        //Tinh thoi gian chay
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Time running: " + totalTime + " millisecond");
    }

    private  static void findMaxAndMin(ConcurrentHashMap m, String find, BufferedWriter bw) throws IOException {
        LinkedHashMap m1 = sortByValues(m, find);
        Set set1 = m1.entrySet();
        Iterator iterator1 = set1.iterator();
        bw.newLine();
        for(int i =0; i<10; i++){
            Map.Entry me  = (Map.Entry)iterator1.next();
            bw.write(me.getKey() + " " + me.getValue());
            bw.newLine();
        }
        bw.write("================================");
        bw.newLine();

    }

    private static LinkedHashMap sortByValues(ConcurrentHashMap map, String sort) {
        List list = new LinkedList(map.entrySet());

        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                if(sort == "Max"){
                    return ((Comparable) ((Map.Entry) (o2)).getValue())
                            .compareTo(((Map.Entry) (o1)).getValue());
                }
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });


        LinkedHashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

}
