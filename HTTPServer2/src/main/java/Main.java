import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.rapidoid.config.Conf;
import org.rapidoid.goodies.ConfigHandler;
import org.rapidoid.gui.GUI;
import org.rapidoid.http.ReqHandler;
import org.rapidoid.setup.App;
import org.rapidoid.setup.On;
import org.rapidoid.u.U;

import java.util.Map;

public class Main{
    public static void main(String[] args) {
        App.bootstrap(args, "profiles=mysql,foo");



        Map<String, Object> myConfig = Conf.section("my").toMap();
        On.get("/my").mvc(() -> GUI.grid(myConfig));

//        On.req(req -> {
//           return new JSONObject(myConfig);
//        });

    }

}