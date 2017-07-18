import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;

/**
 * Created by chien on 5/15/2017.
 * Các bước làm:
 * Tạo Class Bai4Point :
 * Sinh điểm Point(x,y) cách điểm M(x0,y0) không quá d đơn vị (x0, y0, d là số cụ thể được truyền vào)
 * Giải thích cách sinh điểm trong file "Giải thích cách sinh ra điểm thỏa mãn - Bài 4.docx"
 *
 * Tạo Class Bai4Callable:
 * implements Callable, Sinh ra numOfPoint điểm thỏa mãn
 * Ghi các điểm tìm được vào list
 *
 * Tạo Class RunBai4:
 * Tạo executorService để quản lý các luồng
 * Tạo 3 luồng sinh số và chạy
 * Đợi đến khi callable hoàn thành
 * Tạo luồng ghi file
 * Ghi các điểm trong list vào file
 * Đóng luồng ghi file
 * Tắt executorService
 */
public class RunBai4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        //Tính thời gian
        long startTime = System.currentTimeMillis();

        ExecutorService executorService = Executors.newCachedThreadPool();
        int numFile = 3;
        Future<Integer>[] future = new Future[numFile];
        Integer[] resultFuture = new Integer[numFile];

        Callable task1, task2, task3;
        int countFuture = 0;

        //Sinh 8.000 điểm đầu tiên có cách điểm A(800, 800) một độ dài không quá 400 đơn vị
        task1 = new Bai4Callable(800,800,400,8000);
        future[countFuture++]= executorService.submit(task1);

        //Sinh 10.000 điểm tiếp theo cách điểm B(4000,800) không quá 500 đơn vị
        task2 = new Bai4Callable(4000,800,500,10000);
        future[countFuture++]= executorService.submit(task2);

        //Sinh 12.000 điểm cuối cùng cách điểm C(2400, 2400) không quá 600 đơn vị
        task3 = new Bai4Callable(2400,2400,600,12000);
        future[countFuture++]= executorService.submit(task3);

        //đợi đến khi hàm callable hoàn thành
        for(int i=0; i<numFile; i++){
            resultFuture[i] = future[i].get();
        }

        //Tạo luồng ghi file
        Writer w = new FileWriter("data\\output4.txt");
        BufferedWriter bw=new BufferedWriter(w);
        for(Bai4Point list: Bai4Callable.list){
            bw.write(list.getX() + " " + list.getY());
            bw.newLine();
        }
        //Đóng luồng ghi file
        bw.close();
        //
        executorService.shutdown();

        //Tinh thoi gian chay
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Time running: " + totalTime + " millisecond");

    }
}
