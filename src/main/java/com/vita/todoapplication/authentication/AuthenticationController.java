package com.vita.todoapplication.authentication;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//CONTROLLER
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class AuthenticationController {

    //hello-world-bean
    @GetMapping(path="/basicauth")
    public AuthenticationBean helloWorldBean(){
        //throw new RuntimeException("Some Error has Happened!"); for Error test
        return new AuthenticationBean("authenticated!");
    }


}
