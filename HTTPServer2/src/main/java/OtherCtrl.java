import org.rapidoid.annotation.Controller;
import org.rapidoid.annotation.GET;
import org.rapidoid.annotation.Profiles;

@Controller
@Profiles("default")
public class OtherCtrl {

    @GET
    public String hi() {
        return "hi, OTHER controller!";
    }

}