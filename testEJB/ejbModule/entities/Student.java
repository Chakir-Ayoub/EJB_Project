package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.lang.String;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
public class Student extends User implements Serializable {

	private String firstname;
	private String lastname;
	private String telephone;
	//private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "filiere_id", referencedColumnName = "id")
	private Filiere filiere;
	
	public Student() {
		super();
	}   
	
	
	public Filiere getFiliere() {
		return filiere;
	}


	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}


	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}   
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}   
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
   
}
