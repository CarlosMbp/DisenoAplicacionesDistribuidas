package IngerGYM.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import IngerGYM.entidades.Tarifa;



@Repository
public interface RepositorioTarifa extends JpaRepository<Tarifa, Long> {
	
	Tarifa findById(long id);
}