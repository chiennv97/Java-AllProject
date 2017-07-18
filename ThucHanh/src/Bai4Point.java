import java.util.Random;

/**
 * Created by chien on 5/15/2017.
 * //Sinh điểm Point(x,y) cách điểm M(x0,y0) không quá d đơn vị (x0, y0, d là số cụ thể được truyền vào)
 *
 */
public class Bai4Point {
    private int x;
    private int y;

    public Bai4Point(int x0, int y0, int d){
        //sinh ra x bất kì trong khoảng [x0 - d;x0 + d]
        Random rand = new Random();
        x = x0 + rand.nextInt(2*d + 1) - d;

        //chọn khoảng để sinh ra y để thỏa mãn khoảng cách của Point(x,y) và M(x0,y0) sinh ra không vượt quá d
        double deltaY = Math.sqrt(d*d - (x-x0)*(x-x0));

        //chọn y trong khoảng [y0 - deltaY; y0 + deltaY]
        int floorDeltaY = (int) Math.floor(deltaY);
        y = y0 + rand.nextInt((int) (2* floorDeltaY + 1))  - floorDeltaY;



    }
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

}
