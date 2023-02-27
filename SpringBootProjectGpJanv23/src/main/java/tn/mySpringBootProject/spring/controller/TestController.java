package tn.mySpringBootProject.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	
	//@RequestMapping(method = RequestMethod.GET, value = "/test/{name}")
	@GetMapping(value = "/test/{name}")
	public String testController(@PathVariable("name") String name)
	{
		return "Bonjour !!!"+" "+name;
	}
	
}
