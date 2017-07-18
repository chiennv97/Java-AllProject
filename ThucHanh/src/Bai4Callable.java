import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Callable;

/**
 * Created by chien on 5/15/2017.
 */
public class Bai4Callable implements Callable {
    //Tạo 1 biến Vector dùng chung để lưu tất cả các điểm sinh ra bởi các luồng
    public static List<Bai4Point> list = new Vector<Bai4Point>();

    int x0, y0;
    //numOfPoint: số điểm cần sinh ra
    int distance, numOfPoint;

    public Bai4Callable(int x0,int y0, int distance, int numOfPoint){
        this.x0 = x0;
        this.y0 = y0;
        this.distance = distance;
        this.numOfPoint = numOfPoint;
    }

    @Override
    public Object call() throws Exception {
        //sinh ra numOfPoint điểm thỏa mãn
        for(int i =0; i<numOfPoint; i++){
            Bai4Point point = new Bai4Point(this.x0, this.y0, distance);
            //Ghi điểm tìm được vào list
            list.add(point);
        }
        return null;
    }
}
