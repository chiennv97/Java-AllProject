import org.jetbrains.annotations.NotNull;

/**
 * Created by chien on 5/9/2017.
 */
public class Book /*implements Comparable*/{
    int ID;
    int publishedYear;
    String name;

    public Book(int ID, int publishedYear, String name){
        this.ID = ID;
        this.publishedYear = publishedYear;
        this.name = name;
    }
    public String toString(){
        return ID + " - " + publishedYear + " - "+ name;
    }

//    @Override
//    public int compareTo(@NotNull Object o) {
//        Book b = (Book) o;
//        if(ID > b.ID) return 1;
//        else if (ID < b.ID) return -1;
//        else return 0;
//    }
}
