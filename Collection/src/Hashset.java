import java.util.Set;

/**
 * Created by chien on 5/10/2017.
 */
import java.util.*;
public class Hashset {
        public static void main(String[] args) {
            Set set = new TreeSet(); //sắp xếp tăng dần
            //Set set = new LinkedHashSet(); //theo thứ tự put vào
            //Set set = new HashSet(); // xếp lung tung
            set.add(1);
            set.add(6);
            set.add(5);
            set.add(9);
            set.add(4);
            if(set.contains(5)){
                set.remove(5);
            }
            List list = new ArrayList();
            list.add(16);
            list.add(7);
            list.add(18);
            list.add(7);
            set.addAll(list);

            Iterator it = set.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }
//            for(Object element : set){
//                System.out.println(element);
//            }
        }
}
