package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegController {
    @RequestMapping("/home")
    public String home()
    {
        System.out.println("This is home url !!");
        return "index";
    }
}
