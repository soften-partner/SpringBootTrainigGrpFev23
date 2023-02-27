package tn.mySpringBootProject.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.mySpringBootProject.spring.entities.Post;
import tn.mySpringBootProject.spring.entities.User;
import tn.mySpringBootProject.spring.repository.IPostRepository;
import tn.mySpringBootProject.spring.repository.UserRepository;

@Service
public class PostServiceImpl implements IPostService{

	@Autowired
	UserRepository userRep;
	
	@Autowired
	IPostRepository postRep;
	@Override
	public Post addPost(Post pst, Long idUser) {
		// TODO Auto-generated method stub
		
		User user = userRep.findById(idUser).get();
		
		
		pst.setUserp(user);
		return postRep.save(pst);
	}

}
