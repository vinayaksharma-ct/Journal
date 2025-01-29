package com.Journal.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Check {
    @GetMapping("/check")
    public String check(){
        return "Ok";
    }
}
