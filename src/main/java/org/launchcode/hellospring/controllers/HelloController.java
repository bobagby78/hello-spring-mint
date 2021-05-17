package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {

    @GetMapping("hello")
    @ResponseBody
    public String hello(){
        return "<html>" +
                "<h1>Hello, Spring</h1>" +
                "</html>";
    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //handle reqs of the form /hello?name=launchcode
    @GetMapping("helloParam")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    //handles requests of the form/formInputName
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name +  "!";
    }

    @GetMapping("forms")
    @ResponseBody
    public String helloForm(){
        return
                "<html>" +
                        "<body>" +
                            "<form action = 'helloParam'>" + //submits the request to hello
                                "<input type = 'text' name = 'name'>" +
                                "<input type = 'submit' value = 'Greet me!'>" +
                            "</form>" +
                        "</body>" +
                "</html>";
    }
}
