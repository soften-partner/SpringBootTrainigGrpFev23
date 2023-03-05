package tn.mySpringBootProject.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.mySpringBootProject.spring.entities.Filee;

@Repository
public interface IFileeRepository extends JpaRepository<Filee, Long>{

}
