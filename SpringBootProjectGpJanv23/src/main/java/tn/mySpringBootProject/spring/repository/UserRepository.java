package tn.mySpringBootProject.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.mySpringBootProject.spring.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Boolean existsByUserName(String username);
	
	User findByUserName(String username);
	
	@Query(value = "select * from user u where u.user_name like :cle%", nativeQuery = true)
	List<User> getAllUserByFname(@Param("cle") String cle);
	
	@Query(value = "select id_user from user_role ur where ur.idrole=1", nativeQuery = true)
	List<Long> findUsersByIdRole();
	
	@Query(value = "select id_user from user_role ur where ur.idrole=?1", nativeQuery = true)
	List<Long> findUsersByIdRole(Long idrole);
	
	@Query(value = "select * from user_role ur, user u where ur.id_user= u.id_user and ur.idrole=?1", nativeQuery = true)
	List<User> getUsersByIdRole(Long idrole);
	
}
