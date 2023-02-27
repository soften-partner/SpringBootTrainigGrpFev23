package tn.mySpringBootProject.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.mySpringBootProject.spring.entities.Role;
import tn.mySpringBootProject.spring.services.RoleServiceImpl;

@RestController
public class RoleController {

	@Autowired
	RoleServiceImpl roleServ;
	
	@PostMapping(value = "/addRole")
	public Role addRole(@RequestBody Role role)
	{
		return roleServ.addRole(role);
	}
}
