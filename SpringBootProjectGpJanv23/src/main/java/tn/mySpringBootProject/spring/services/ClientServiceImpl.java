package tn.mySpringBootProject.spring.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.mySpringBootProject.spring.entities.Client;
import tn.mySpringBootProject.spring.repository.IClientRepository;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	IClientRepository clientRep;
	
	@Override
	public Client addClient(Client client) {
		// TODO Auto-generated method stub
		System.out.println("seeeeeerv:"+client.getName());
	//	System.out.println("seeeeeerv"+client.getIdclt());
		return clientRep.save(client); 
		
	}

}
