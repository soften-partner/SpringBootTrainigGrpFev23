package tn.mySpringBootProject.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.mySpringBootProject.spring.entities.Client;
import tn.mySpringBootProject.spring.services.ClientServiceImpl;

@RestController
public class ClientController {
	
	@Autowired
	ClientServiceImpl clientServ;
	
	@PostMapping("/addClient")
	public Client addClient(@RequestBody Client client)
	{
		System.out.println(client.getName());
		//System.out.println(client.getIdclt());
		return clientServ.addClient(client);
	}

}
