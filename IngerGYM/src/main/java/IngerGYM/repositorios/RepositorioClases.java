package IngerGYM.repositorios;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import IngerGYM.entidades.Clases;


@Repository
public interface RepositorioClases extends JpaRepository<Clases, Long> {
	
	Clases save(Clases clase);
	
	Clases findById(long id);
	
	List<Clases> findAll();
}