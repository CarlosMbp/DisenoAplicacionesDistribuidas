package IngerGYM.seguridad;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import IngerGYM.entidades.Cliente;
import IngerGYM.repositorios.RepositorioClientes;

@Component
public class DatabaseUserLoader {

	@Autowired
	private RepositorioClientes repositorioClientes;
	
	@PostConstruct
	public void init() {

		// Sample users
      /*
		repositorioClientes.save(new Cliente("paco","paco@gmail.com",54,"pass","ROLE_USER"));
		repositorioClientes.save(new Cliente("admin","paco@gmail.com",54,"pass","ROLE_USER", "ROLE_ADMIN"));
	*/}

}

