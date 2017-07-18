/**
 * Created by chien on 5/10/2017.
 */
import java.util.*;
public class Hashmap {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("java", 1);
        map.put("c++", 2);
        map.put("python", 3);
        map.put("c#", 4);
        map.remove("java");
        Iterator it  = map.keySet().iterator();
        while(it.hasNext()){
            Object key = it.next();
            Object value = map.get(key);
            System.out.println(key + " : " + value);
        }
//        Set keys = map.keySet();
//        for(Object key : keys){
//            Object value = map.get(key);
//            System.out.println(key + ":" + value);
//        }
    }
}
