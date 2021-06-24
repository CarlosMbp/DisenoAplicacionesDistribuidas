package IngerGYM.servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import IngerGYM.entidades.Opinion;
import IngerGYM.repositorios.RepositorioOpiniones;
import java.util.List;


@Service
public class ServicioOpiniones {

	
	@Autowired
	private RepositorioOpiniones repositorioOpiniones;
	
	
	public List<Opinion> findAll(){
		return repositorioOpiniones.findAll();
	}
	
	public Opinion findById(long id){
		return repositorioOpiniones.findById(id);
	}
	
	public void save(Opinion opinion) {
		repositorioOpiniones.save(opinion);
	}
	
	public void deleteById(long id) {
		repositorioOpiniones.deleteById(id);
	}
	
	//Para eliminar un usuario, primero eliminaremos sus opiniones
	//Devuelve 1 si se ha eliminado correctamente
	//Devuelve -1 si el cliente nop tenia opinion
	public int deleteByUserId(long idUser) {
		List<Opinion> opiniones = repositorioOpiniones.findAll();
	
		for(Opinion opinion: opiniones) {
			if(opinion.getIdCliente()==idUser) {
				//Si el id del cliente de la opinion= al id pasado la eliminamos
				repositorioOpiniones.deleteById(opinion.getId());;
				return 1;
			}
		}
		
		return -1;
	}
}
