package entities;


import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: Role
 *
 */
@Entity

public class Role implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	//private static final long serialVersionUID = 1L;

	//
	//@ManyToMany
	//List<User> users;
	
	public Role() {
		super();
	}   
	
	public Role(String name) {
		this.name = name;
	}  
	
	//public List<User> getUsers() {
		//return users;
	//}
	//public void setUsers(List<User> users) {
	//	this.users = users;
	//}
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
}
