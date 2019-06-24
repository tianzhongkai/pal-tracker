package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    private final String  welcomeStr;

    public WelcomeController(@Value("${welcome.message}") String welcomeStr){
this.welcomeStr = welcomeStr;
    }

    @GetMapping("/")
    public String sayHello() {
        return welcomeStr;
    }
    @GetMapping("/welcome")
    public String welecome() {
        return welcomeStr;
    }
}