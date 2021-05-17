package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody
@RequestMapping("hello") //be sure to add this to the URL when trying it out.
public class HelloController {
	// resides at /hello/hello
	@GetMapping("hello")
	public String hello(){
		return "<html>" +
				"<h1>Hello, Spring</h1>" +
				"</html>";
	}
	// resides at /hello/goodbye
	@GetMapping("goodbye")
	public String goodbye(){
		return "Goodbye, Spring!";
	}

	// resides at /hello/helloParam
	//handle reqs of the form /hello?name=launchcode
	@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "helloParam")
	public String helloWithQueryParam(@RequestParam String name){
		return "Hello, " + name + "!";
	}

	// resides at /hello/hello/{name}
	//handles requests of the form/formInputName
	@GetMapping("hello/{name}")
	public String helloWithPathParam(@PathVariable String name){
		return "Hello, " + name +  "!";
	}
//this piece of garbage isn't doing SHIT

	// resides at /hello/form
	@GetMapping("form")
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

