package tn.mySpringBootProject.spring.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idrole;
	@Enumerated(EnumType.STRING)
	private RoleName roleName;

	@ManyToMany(mappedBy = "listRole")
	private List<User> listuser= new ArrayList();
	
	public List<User> getListuser() {
		return listuser;
	}
	public void setListuser(List<User> listuser) {
		this.listuser = listuser;
	} Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Role(Long idrole, RoleName roleName, List<User> listuser) {
		super();
		this.idrole = idrole;
		this.roleName = roleName;
		this.listuser = listuser;
	}
	public Long getIdrole() {
		return idrole;
	}
	public void setIdrole(Long idrole) {
		this.idrole = idrole;
	}
	public RoleName getRoleName() {
		return roleName;
	}
	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "Role [idrole=" + idrole + ", roleName=" + roleName + ", listuser=" + listuser + "]";
	}
	
}
