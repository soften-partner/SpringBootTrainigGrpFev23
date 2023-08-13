package tn.mySpringBootProject.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.mySpringBootProject.spring.entities.Client;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {

}
