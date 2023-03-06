package tn.mySpringBootProject.spring.entities;

import java.io.Serializable;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private String password;
	private String confirmPassword;
	private String adresse;
	private String role;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "userRole", joinColumns = @JoinColumn(name="idUser"), inverseJoinColumns = @JoinColumn(name="idrole"))
	private List<Role> listRole= new ArrayList<>(); 
	
	@JsonManagedReference
	@OneToOne
	private Filess file;
	
	
	@OneToMany(mappedBy = "userp")
	private List<Post> listPost= new ArrayList<>();
	
	@JsonManagedReference
	@OneToOne
	private Filee filee;
	
	



	public void addRole(Role role) {
		// TODO Auto-generated method stub
		
		this.listRole.add(role);
	}



	
	
	
}
