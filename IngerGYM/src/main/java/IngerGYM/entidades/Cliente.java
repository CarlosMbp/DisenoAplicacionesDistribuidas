package IngerGYM.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Cliente implements Serializable{

	private String name;
	private String email;
	private int edad;
	private String passwordHash;
	
	@ManyToMany
	protected List<Clases> clases;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;
	
	
	public Cliente() {
	}
	
	public Cliente(String usuario,String email,int edad, String contrasena,String... roles){
		super();
		this.name= usuario;
		this.email=email;
		this.edad=edad;
		this.passwordHash=  new BCryptPasswordEncoder().encode(contrasena);
		this.clases=new ArrayList<>();
		this.roles = new ArrayList<>(Arrays.asList(roles));
		
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public void addClase(Clases clase) {
		 clases.add(clase);
	}
	
	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public List<Clases> getClases() {
		return clases;
	}
	
	public void setClases(List<Clases> clases) {
		this.clases = clases;
	}
	
	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	@Override
	public String toString() {
		return "Cliente [tlf="  + ", name=" + "usuario ]";
	}
}