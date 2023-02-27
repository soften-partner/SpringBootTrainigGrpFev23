package tn.mySpringBootProject.spring.services;

import tn.mySpringBootProject.spring.entities.Post;

public interface IPostService {

	public Post addPost(Post pst, Long idUser);

}
