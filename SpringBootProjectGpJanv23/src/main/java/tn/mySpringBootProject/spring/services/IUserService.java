package tn.mySpringBootProject.spring.services;

import java.util.List;

import tn.mySpringBootProject.spring.entities.User;

public interface IUserService {

	public User addUser(User user);
	public List<User> addlistuser(List<User> listuser);
	public String addUserWTCP(User user);
	
	public String addUserWTUsername(User user);
	
	public User updateUser(User user, Long idUser);
	
	public String deleteUser(Long idUser);
	
	public User findUserByUsername(String username);
	
	public List<User> getUsersByUsername(String ch);
	
	public User AddUserRole(Long iduser, Long idRole);
	
	public List<Long>findUsersByIdRole ();
	public List<Long>findUsersByIdRole (Long idrole);
	
	List<User> getUsersByIdRole(Long idrole);
}
