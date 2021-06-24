package IngerGYM.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IngerGYM.entidades.Cliente;


@Repository
public interface RepositorioClientes extends JpaRepository<Cliente, Long> {
	
	Cliente findById(long id);
	Cliente findByName(String usuario);
}