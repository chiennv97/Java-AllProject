import org.rapidoid.annotation.Controller;
import org.rapidoid.annotation.GET;
import org.rapidoid.annotation.Profiles;

@Controller
@Profiles("foo")
public class FooCtrl {

    @GET
    public String hi() {
        return "hi, FOO controller!";
    }

}