/**
 * Created by chien on 5/10/2017.
 */
import java.util.*;
public class ComparableInterface {
    public static void main(String[] args) {
          List list = new ArrayList();
//        Set list = new TreeSet(new IDComparator());
        list.add(new Book(11, 2015, "book 5"));
        list.add(new Book(55, 2009,"book 1"));
        list.add(new Book(77, 2012,"book 6"));
        list.add(new Book(33, 2014,"book 7"));

        Collections.sort(list, new IDComparator());

        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }


}
