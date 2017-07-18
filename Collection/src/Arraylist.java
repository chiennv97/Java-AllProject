/**
 * Created by chien on 5/9/2017.
 */
import java.util.*;
public class Arraylist {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(5.5);
        list.add(2);
        list.add("string");
        list.add(4, "cao");
//        list.add(new Book("Book 1"));
        /*for(int i = 0; i<list.size(); i++){
            Object elements = list.get(i);
            System.out.println(elements);
        }*/
        list.set(2,100); //replace the element
        list.remove("string");
        if(list.contains("string")){
            System.out.println("Existed");
        }
        for(Object element : list){
            System.out.println(element);
        }
    }
}
