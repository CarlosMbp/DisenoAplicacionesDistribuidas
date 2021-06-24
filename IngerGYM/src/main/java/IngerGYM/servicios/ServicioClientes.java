package IngerGYM.servicios;


import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import IngerGYM.entidades.Clases;
import IngerGYM.entidades.Cliente;
import IngerGYM.entidades.ContadorAforo;
import IngerGYM.entidades.Salas;
import IngerGYM.repositorios.RepositorioClases;
import IngerGYM.repositorios.RepositorioClientes;
import IngerGYM.repositorios.RepositorioSalas;


@Service
public class ServicioClientes {

	ContadorAforo Nado;
	ContadorAforo Zumb;
	ContadorAforo Gym;
	ContadorAforo Aq;
	
	@Autowired
	private RepositorioClientes repositorioClientes;

	@Autowired
	private RepositorioSalas repositorioS;
	
	@Autowired
	private ServicioClases repositorioCl;
	
	@PostConstruct
	public void init() {

     /*
		Salas piscina=new Salas("Piscina",2);
		repositorioS.save(piscina);
		
		Salas gimnasio=new Salas("Gym",40);
		repositorioS.save(gimnasio);
		
		Salas comun=new Salas("Zumba",50);
		repositorioS.save(comun);
		
		//public Clases (Salas sala,String prof,String tipo,int dia, int hora)
		
		Clases AquaGym=new Clases(piscina,"Maria","AquaGYM",3,17);
		repositorioCl.save(AquaGym);
		Clases NadoLibre=new Clases(piscina,"Juan","NadoLibre",5,12);
		repositorioCl.save(NadoLibre);
		Clases Zumba=new Clases(comun,"Aitor","Zumba",1,18);
		repositorioCl.save(Zumba);
		Clases gym=new Clases(gimnasio,"-","gym");
		repositorioCl.save(gym);
	*/
	}
	
	public boolean reservarPiscina(int d,int h) {
		
			return true;

	}
	
	public boolean reservarGimnasio(int d,int h) {
		
			return true;

	}	
	
	public int getPlazasZumba() {
		
		int d=1;
		int h=8;
		
		return Zumb.getAforo(d, h);
	} 
	
	public int getPlazasAquagym() {
		
		int d=3;
		int h=7;
		
		return Aq.getAforo(d, h);
	} 
	
	
	public Salas getSala(int numero) {
		
		List <Salas> listaSala=repositorioS.findAll();
		Salas sala=listaSala.get(numero);
		return sala;
	}

	public void guardarClase(Clases clase) {
		
		repositorioCl.save(clase);
	}

	public int posSala(String nombre) {
		
		List <Salas> listaSala=repositorioS.findAll();
		
		boolean encontrado=false;
		int pos=0;
		for(Salas sala : listaSala) {
			
			if(sala.getNombre().equals(nombre) ) {
				encontrado = true;
				break;
			}
			pos++;
		}
		if(encontrado==true) {
			return pos;
		}else {
			return -1;
		}
	}
	
	public Clases getClase(int numero) {
		
		List <Clases> listaClase=repositorioCl.findAll();
		Clases clase=listaClase.get(numero);
		return clase;
	}
	
	public int posClase(String nombre) {
		
		List <Clases> listaClase=repositorioCl.findAll();
		boolean encontrado=false;
		int pos=0;
		for(Clases clase : listaClase) {
			
			if(clase.getTipo().equals(nombre) ) {
				encontrado = true;
				break;
			}
			pos++;
		}
		if(encontrado==true) {
			return pos;
		}else {
			return -1;
		}
	}
	

	public List<Cliente> findAll(){
		
		return repositorioClientes.findAll();
	}
	
	public Cliente findById(long id){
		
		return repositorioClientes.findById(id);
	}
	
	public Cliente findByNombre(String nombre){
		
		List<Cliente> clientes= this.repositorioClientes.findAll();
		for(Cliente cliente: clientes) {
			if(cliente.getName().equals(nombre)) {
				return cliente;
			}
		}
		//Si hemos llegado aqui devolvemos null
		return null;
	}
	
	public void save(Cliente usuario) {
		
		repositorioClientes.save(usuario);
	}
	
	public void deleteById(long id) {
		
		repositorioClientes.deleteById(id);
	}
}