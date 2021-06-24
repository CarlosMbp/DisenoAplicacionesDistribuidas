package IngerGYM.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IngerGYM.entidades.Salas;

@Repository
public interface RepositorioSalas extends JpaRepository<Salas, Long> {
	
}
