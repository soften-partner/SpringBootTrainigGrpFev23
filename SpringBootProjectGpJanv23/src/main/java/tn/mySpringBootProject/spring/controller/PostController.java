package tn.mySpringBootProject.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.mySpringBootProject.spring.entities.Post;
import tn.mySpringBootProject.spring.services.PostServiceImpl;

@RestController
public class PostController {
	@Autowired
	PostServiceImpl postServ;
	
	@PostMapping(value = "/addPostUser/{iduser}")
	public Post addPostUser(@RequestBody Post post, @PathVariable("iduser") Long iduser)
	{
		return postServ.addPost(post, iduser);
	}

}
