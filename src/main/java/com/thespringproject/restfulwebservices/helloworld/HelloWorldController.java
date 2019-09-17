package com.thespringproject.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	//initial get
	@RequestMapping(method=RequestMethod.GET, path="/helloworld")
	public String helloWorld() {
		return ("Hello World!");
	}

	//gets bean
	@GetMapping( path="/helloworldbean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Do you see my message?");
	}
	
	//gets with a path variable
		@GetMapping( path="/helloworld/pathVariable/{name}")
		public HelloWorldBean helloWorldBean(@PathVariable String name) {
			return new HelloWorldBean("Do you see my message"+" "+name+"?");
		}
}
