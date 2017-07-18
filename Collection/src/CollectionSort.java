/**
 * Created by chien on 5/10/2017.
 */
import java.util.*;
public class CollectionSort {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(4);
        list.add(1);
        list.add(9);
        list.add(5);

        Collections.sort(list);
//        Collections.reverse(list);

       // Collections.shuffle(list); //tráo bất kì các phần tử

//        int result = Collections.binarySearch(list, 3);
//        System.out.println("Found: "+ result);

//        Iterator it = list.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
        System.out.println("Max: "+ Collections.max(list));
    }
}
