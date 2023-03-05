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
	
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "userRole", joinColumns = @JoinColumn(name="idUser"), inverseJoinColumns = @JoinColumn(name="idrole"))
	private List<Role> listRole= new ArrayList<>(); 
	
	@JsonIgnore
	@OneToOne
	private Filess file;
	
	@OneToMany(mappedBy = "userp")
	private List<Post> listPost= new ArrayList<>();
	
	
	@OneToOne
	private Filee filee;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Role> getListRole() {
		return listRole;
	}
	public void setListRole(List<Role> listRole) {
		this.listRole = listRole;
	}
	
	

	public User(Long idUser, String firstName, String lastName, String userName, String email, String password,
			String confirmPassword, String adresse, List<Role> listRole, Filess file, List<Post> listPost,
			Filee filee) {
		super();
		this.idUser = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.adresse = adresse;
		this.listRole = listRole;
		this.file = file;
		this.listPost = listPost;
		this.filee = filee;
	}

	public Filee getFilee() {
		return filee;
	}

	public void setFilee(Filee filee) {
		this.filee = filee;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Filess getFile() {
		return file;
	}

	public void setFile(Filess file) {
		this.file = file;
	}

	public List<Post> getListPost() {
		return listPost;
	}

	public void setListPost(List<Post> listPost) {
		this.listPost = listPost;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", email=" + email + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", adresse=" + adresse + ", listRole=" + listRole + ", file=" + file + ", listPost=" + listPost + "]";
	}

	public void addRole(Role role) {
		// TODO Auto-generated method stub
		
		this.listRole.add(role);
	}



	
	
	
}
