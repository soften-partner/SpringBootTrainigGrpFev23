package tn.mySpringBootProject.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.mySpringBootProject.spring.entities.Post;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long>{

	
}
