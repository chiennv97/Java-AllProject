/**
 * Created by chien on 5/11/2017.
 */
import java.util.*;
public class CompareAll implements Comparator<Book>{
    @Override
    public int compare(Book o1, Book o2) {
        if(o1.ID > o2.ID){
            return 1;
        }
        if(o1.ID < o2.ID){
            return -1;
        }
        if(o1.publishedYear > o2.publishedYear){
            return 1;
        }
        if(o1.publishedYear < o2.publishedYear){
            return -1;
        }
        if(o1.name.compareTo(o2.name)<0){
            return -1;
        }
        if(o1.name.compareTo(o2.name)>0){
            return 1;
        }
        return 0;
    }
}
