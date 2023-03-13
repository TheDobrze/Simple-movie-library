package simpleproject.movielibrary;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class movieRepository {

    @GetMapping("/test")
    public int test(){
        return 1;
    }
}
