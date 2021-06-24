package IngerGYM.entidades;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Salas implements Serializable {
	
	private int aforoMAX;
	private String nombre;
	
	@OneToMany
	private List<Clases> clases;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	public Salas(String a,int n) {
	this.nombre=a;
	this.aforoMAX=n;
	
	}
	
	public Salas() {
		
	}
	
	public boolean compHora(int d, int h) {
		
		 Auxiliar aux=new Auxiliar();
		int reserva=d*7+h;
		return aux.estaLibre(reserva);	
	}
	
	public void setClase(Clases clase) {
		
		clases.add(clase);
	}
	
	public void cogerHora(int d, int h) {
		
		int reserva=d*7+h;
		Auxiliar aux=new Auxiliar();
		aux.reservar(reserva);
	}
	public void cogerHora() {
		
		Auxiliar aux=new Auxiliar();
		aux.reservar();
	}
	
	public int getAforoMAX() {
		
		return aforoMAX;
	}

	public void setAforoMAX(int aforoMAX) {
		
		this.aforoMAX = aforoMAX;
	}

	public String getNombre() {
		
		return nombre;
	}

	public long getId() {
		
		return id;
	}

	public void setNombre(String nombre) {
		
		this.nombre = nombre;
	}
}