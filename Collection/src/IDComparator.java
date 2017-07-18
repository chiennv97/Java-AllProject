/**
 * Created by chien on 5/10/2017.
 */
public class IDComparator implements java.util.Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        Book b1 = (Book) o1;
        Book b2 = (Book) o2;
        if(b1.publishedYear > b2.publishedYear) return 1;
        else if(b1.publishedYear < b2.publishedYear) return -1;
        else return 0;
    }
}
