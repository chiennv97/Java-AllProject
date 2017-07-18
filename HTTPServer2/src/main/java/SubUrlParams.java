//import org.rapidoid.annotation.Controller;
//import org.rapidoid.annotation.GET;
//import org.rapidoid.annotation.POST;
//import org.rapidoid.u.U;
//
///**
// * Created by chien on 6/25/2017.
// */
//@Controller
//public class SubUrlParams {
//
//    @GET("/hey/{name}/{age}")
//    public String hey(String name, int age) {
//        return U.frmt("Hey %s (%s)", name, age);
//    }
//
//    @POST("/size/{s}")
//    public int size(String s) {
//        return s.length();
//    }
//
//}