package entities;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


/**
 * Entity implementation class for Entity: Filiere
 *
 */
@Entity

public class Filiere implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	private String name;
	//private static final long serialVersionUID = 1L;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "filiere")
	private List<Student> students;
	
	public Filiere() {
		super();
	}  
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
}
