/**
 * Created by chien on 5/11/2017.
 */
import java.util.*;
public class PriorityQueueDemo {
    public static void main(String[] args) {
        Queue queue= new PriorityQueue(new CompareAll());
        queue.add(new Book(12,2017,"so"));
        queue.add(new Book(15,2016,"so2"));
        queue.add(new Book(12,2017,"so3"));
        queue.add(new Book(24,2016,"so4"));

        Iterator it = queue.iterator();
        while(it.hasNext()){
            System.out.println(queue.poll());
        }
    }
}
