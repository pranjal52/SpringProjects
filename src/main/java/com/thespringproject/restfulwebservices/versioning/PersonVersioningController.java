package com.thespringproject.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	
	@GetMapping("v1/person")
	public PersonV1 personV1 () {
		return new PersonV1("Pranjal Srivastava");
	}
	
	
	@GetMapping("v2/person")	
	public PersonV2 personV2 () {
		return new PersonV2("Pranjal", "Srivastava");
	}
	
	@GetMapping(value="/person", headers= "X-API-VERSION=1")
	public PersonV1 personHeaderV1 () {
		return new PersonV1("Pranjal Srivastava");
	}
	
	
	@GetMapping(value="/person", headers= "X-API-VERSION=2")
	public PersonV2 personHeaderV2 () {
		return new PersonV2("Pranjal", "Srivastava");
	}

}
