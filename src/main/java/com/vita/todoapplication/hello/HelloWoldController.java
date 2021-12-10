package com.vita.todoapplication.hello;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//CONTROLLER
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWoldController {
    //GET
    //URI
    //method
    @GetMapping(path="/hello-world")
    public String helloWorld(){
        return "Hello world";
    }

    //hello-world-bean
    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        //throw new RuntimeException("Some Error has Happened!"); for Error test
        return new HelloWorldBean("Hello World");
    }

    //hello-world-bean
    @GetMapping(path="/hello-world-bean/part-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
