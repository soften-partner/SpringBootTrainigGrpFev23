package tn.mySpringBootProject.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.mySpringBootProject.spring.entities.Role;
import tn.mySpringBootProject.spring.repository.IRoleRepository;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	IRoleRepository roleRep;
	
	@Override
	public Role addRole(Role role) {
		// TODO Auto-generated method stub
		return roleRep.save(role);
	}

}
