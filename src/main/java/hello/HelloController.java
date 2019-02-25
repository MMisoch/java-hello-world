package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        String DBUri = System.getenv("DATABASE_URI");
        String DBUser = System.getenv("DATABASE_USER");
        return DBUri + DBUser;
    }

}
