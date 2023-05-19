package com.auth.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @RequestMapping("/authenticate")
    public String home(){
        return "Authentication successful";
    }
}
