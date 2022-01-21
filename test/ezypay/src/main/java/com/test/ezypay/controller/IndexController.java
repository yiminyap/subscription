package com.test.ezypay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	@GetMapping("/")
    public String home1() {
        return "login";
    }

    @GetMapping("/index")
    public String home() {
        return "index";
    }
     
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/403")
    public String error403() {
        return "error/403";
    }
    
    @GetMapping("/400")
    public String error400() {
        return "error/400";
    }

}
