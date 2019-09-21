package com.thespringproject.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
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
		
		@GetMapping( path="/helloworld-internationalized")
		public String helloWorldInternationalized() {
			return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
		}
}
