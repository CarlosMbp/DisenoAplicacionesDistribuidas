package IngerGYM.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IngerGYM.entidades.Opinion;

@Repository
public interface RepositorioOpiniones extends JpaRepository<Opinion, Long> {

	Opinion findById(long id);
}
