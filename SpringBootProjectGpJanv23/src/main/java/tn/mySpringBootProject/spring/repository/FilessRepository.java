package tn.mySpringBootProject.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.mySpringBootProject.spring.entities.Filess;

@Repository
public interface FilessRepository extends JpaRepository<Filess, Long> {

}
