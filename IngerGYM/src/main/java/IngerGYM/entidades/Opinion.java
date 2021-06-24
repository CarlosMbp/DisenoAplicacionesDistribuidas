package IngerGYM.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
public class Opinion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToOne(cascade=CascadeType.ALL)
	private Cliente cliente;
	
	public Cliente getCliente() {
		
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		
		this.cliente = cliente;
	}

	private String comentario;

	public Opinion() {
		
	}

	public Opinion(String comentario) {
		
		super();
		this.comentario = comentario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		
		this.id = id;
	}

	public String getComentario() {
		
		return comentario;
	}

	public void setComentario(String comentario) {
		
		this.comentario = comentario;
	}

	public long getIdCliente() {
		
		return this.cliente.getId();
	}

	@Override
	public String toString() {
		
		return "Opinion [cliente=, comentario=" + comentario + "]";
	}
}