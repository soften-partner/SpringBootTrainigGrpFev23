package tn.mySpringBootProject.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.mySpringBootProject.spring.entities.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {

}
