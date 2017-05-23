import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Smily on 2017/5/5.
 */
@Controller
@EnableAutoConfiguration
public class SpringBootApp {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "哈喽，Spring Boot ！";
    }

    public static void main(String[] args) {
        //第一个简单的应用
        SpringApplication.run(SpringBootApp.class,args);
    }
}
