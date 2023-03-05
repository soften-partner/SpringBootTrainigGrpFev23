package tn.mySpringBootProject.spring.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tn.mySpringBootProject.spring.entities.Filee;
import tn.mySpringBootProject.spring.entities.Filess;
import tn.mySpringBootProject.spring.entities.Role;
import tn.mySpringBootProject.spring.entities.User;
import tn.mySpringBootProject.spring.repository.IRoleRepository;
import tn.mySpringBootProject.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	UserRepository userRep;
	@Autowired 
	IRoleRepository roleRep;

	@Autowired
	FilessServiceImpl fileServ;
	
	@Autowired
	FileeServiceImpl fileeServ;
	
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRep.save(user);
	}

	@Override
	public List<User> addlistuser(List<User> listuser) {
		// TODO Auto-generated method stub
		return userRep.saveAll(listuser);
	}

	@Override
	public String addUserWTCP(User user) {
		// TODO Auto-generated method stub
		
		String ch="";
		if(user.getPassword().equals(user.getConfirmPassword()))
		{
			userRep.save(user);
			ch="user added succsefully";
		}
		else
		{
			ch="check your password and confirmpassword !!!!";
		}
			
		return ch;
	}

	@Override
	public String addUserWTUsername(User user) {
		// TODO Auto-generated method stub
		String ch="";
		if(userRep.existsByUserName(user.getUserName()))
		{
			ch="username already exists !!";
		}
		else
		{
			userRep.save(user);
			ch="user added succssefully !!";
		}
		return ch;
	}

	@Override
	public User updateUser(User user, Long idUser) {
		// TODO Auto-generated method stub
		
		User usr= userRep.findById(idUser).get();
		
		usr.setFirstName(user.getFirstName());
		usr.setLastName(user.getLastName());
		
		return userRep.save(usr);
	}

	@Override
	public String deleteUser(Long idUser) {
		// TODO Auto-generated method stub
		String ch="";
		
		if(userRep.existsById(idUser))
		{
			userRep.deleteById(idUser);
			
		
			
			ch="user deleted successfuly !!";
		}
		else
		{
			ch="user doesn't exist !!";
		}
		 return ch;
	}

	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userRep.findByUserName(username);
	}

	@Override
	public List<User> getUsersByUsername(String ch) {
		// TODO Auto-generated method stub
		return userRep.getAllUserByFname(ch);
	}

	@Override
	public User AddUserRole(Long iduser, Long idRole) {
		// TODO Auto-generated method stub
		
		User user= userRep.findById(iduser).get();
		Role role = roleRep.findById(idRole).get();
		
		user.addRole(role);
		
		return userRep.save(user);
	}

	@Override
	public List<Long> findUsersByIdRole() {
		// TODO Auto-generated method stub
		return userRep.findUsersByIdRole();
	}

	@Override
	public List<Long> findUsersByIdRole(Long idrole) {
		// TODO Auto-generated method stub
		return userRep.findUsersByIdRole(idrole);
	}

	@Override
	public List<User> getUsersByIdRole(Long idrole) {
		// TODO Auto-generated method stub
		return userRep.getUsersByIdRole(idrole);
	}

	@Override
	public User addUserFile(MultipartFile file, Long iduser) throws IOException{
		// TODO Auto-generated method stub
		
		User user = userRep.findById(iduser).get();
		
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+file.getOriginalFilename());
		
		Filess fl=	fileServ.addFile(file);
		
		user.setFile(fl);
		
		return userRep.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRep.findAll();
	}

	@Override
	public User uploadUserFilee(MultipartFile file, Long iduser) throws IOException {
		// TODO Auto-generated method stub
		
		User user = userRep.findById(iduser).get();
		
		Filee fl= fileeServ.addFile(file);
		
		user.setFilee(fl);
		
		return userRep.save(user);
	}

	
	
}
