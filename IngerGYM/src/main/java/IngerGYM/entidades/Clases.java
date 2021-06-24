package IngerGYM.entidades;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
public class Clases implements Serializable{
	
	private String profesor;
	private String tipo; 
	private String nombreSala;
	private int dia=0;
	private int hora=0;
	private int aforo;

	@OneToOne
	private Salas sala;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	public Clases () {
		
	}

	public Clases (Salas sala,String prof,String tipo) {
		
			this.sala=sala;
			this.nombreSala=sala.getNombre();
		
			sala.cogerHora();
			this.profesor=prof;
			this.tipo=tipo;
			
			this.aforo=sala.getAforoMAX();
		
	}
	
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public Clases (Salas sala,String prof,String tipo,int dia, int hora) {
		this.sala=sala;
		this.nombreSala=sala.getNombre();
		if(sala.compHora(dia, hora)==true) {
			sala.cogerHora(dia, hora);
			this.profesor=prof;
			this.tipo=tipo;
			this.dia=dia;
			this.hora=hora;
			this.aforo=sala.getAforoMAX();
		}
		
	
	}
	
	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public String getTipo() {
		return tipo;
	}
	public String getName() {
		return nombreSala;
	}


	public int getAf() {
		return aforo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aforo;
		result = prime * result + dia;
		result = prime * result + hora;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nombreSala == null) ? 0 : nombreSala.hashCode());
		result = prime * result + ((profesor == null) ? 0 : profesor.hashCode());
		result = prime * result + ((sala == null) ? 0 : sala.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clases other = (Clases) obj;
		if (aforo != other.aforo)
			return false;
		if (dia != other.dia)
			return false;
		if (hora != other.hora)
			return false;
		if (id != other.id)
			return false;
		if (nombreSala == null) {
			if (other.nombreSala != null)
				return false;
		} else if (!nombreSala.equals(other.nombreSala))
			return false;
		if (profesor == null) {
			if (other.profesor != null)
				return false;
		} else if (!profesor.equals(other.profesor))
			return false;
		if (sala == null) {
			if (other.sala != null)
				return false;
		} else if (!sala.equals(other.sala))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}





}