package tn.mySpringBootProject.spring.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.mySpringBootProject.spring.entities.User;
import tn.mySpringBootProject.spring.services.UserServiceImpl;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class UserController {

	@Autowired
	UserServiceImpl userServ;
	
	@PostMapping(value = "/addUser")
	public User addUser(@RequestBody User usr)
	{
		return userServ.addUser(usr);
	}
	@PostMapping(value = "/addListUser")
	public List<User> addListUser(@RequestBody List<User> listUser)
	{
		return userServ.addlistuser(listUser);
	}
	
	@PostMapping(value = "/addUserWTCP")
	public String addUserWTCP(@RequestBody User usr)
	{
		return userServ.addUserWTCP(usr);
	}
	@PostMapping(value = "/addUserWTUsername")
	public String addUserWTUsername(@RequestBody User usr)
	{
		return userServ.addUserWTUsername(usr);
	}
	
	@PutMapping(value = "/updateUser/{idUser}")
	public User updateUser(@RequestBody User usr, @PathVariable Long idUser)
	{
		return userServ.updateUser(usr, idUser);
	}
	
	@DeleteMapping(value = "/deletUser/{idUser}")
	public String deleteUser(@PathVariable Long idUser)
	{
		return userServ.deleteUser(idUser);
	}
	@GetMapping(value = "/username/{username}")
	public User deleteUser(@PathVariable String username)
	{
		return userServ.findUserByUsername(username);
	}
	
	@GetMapping(value = "/getAllUsersByUsername/{ch}")
	public List<User> getAllUsersByUsername(@PathVariable("ch") String ch)
	{
		return userServ.getUsersByUsername(ch);
	}
	
	@PostMapping(value = "/addUserRole/{iduser}/{idrole}")
	public User addUserRole(@PathVariable("iduser")  Long iduser, @PathVariable("idrole") Long idrole)
	{
		return userServ.AddUserRole(iduser, idrole);
	}
	
	@GetMapping(value = "/getIdUsersByIdRole")
	public List<Long> findUsersByIdRole()
	{
		return userServ.findUsersByIdRole();
	}
	
	@GetMapping(value = "/getIdUsersByIdRole/{idrole}")
	public List<Long> findUsersByIdRole(@PathVariable("idrole") Long idrole)
	{
		return userServ.findUsersByIdRole(idrole);
	}
	
	@GetMapping(value = "/getUsersByIdRole/{idrole}")
	public List<User> getUsersByIdRole(@PathVariable("idrole") Long idrole)
	{
		return userServ.getUsersByIdRole(idrole);
	}
	
	@PostMapping(value = "/addUserFile/{iduser}")
	public User addUserFile(@RequestParam("file") MultipartFile filee, @PathVariable("iduser") Long iduser ) throws IOException
	{
		return userServ.addUserFile(filee, iduser);
	}
	
	@GetMapping(value = "/getAllUsers")
	public List<User> getAllUsers()
	{
		return userServ.getAllUsers();
	}
	
	@PostMapping(value = "addUserFilee/{iduser}")
	public User addUserFilee(@RequestParam("file") MultipartFile file,@PathVariable("iduser") Long idUser) throws IOException
	{
		return userServ.uploadUserFilee(file, idUser);
	}
}
