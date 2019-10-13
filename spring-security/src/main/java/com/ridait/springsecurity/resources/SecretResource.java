package com.ridait.springsecurity.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecretResource {

    @GetMapping("/secret")
    public String secret(){
        return "Super Secret Content";
    }
}
