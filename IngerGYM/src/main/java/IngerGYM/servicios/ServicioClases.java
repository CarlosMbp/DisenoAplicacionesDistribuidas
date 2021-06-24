package IngerGYM.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import IngerGYM.entidades.Clases;
import IngerGYM.repositorios.*;
import java.lang.Thread;


@CacheConfig(cacheNames="cache")
@Service
public class ServicioClases {
	
	@Autowired
	private RepositorioClases repositorioClases;
	
	@Cacheable
	public List<Clases> findAll() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return repositorioClases.findAll();
	}
	
	@Cacheable
	public Clases findById(long id){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return repositorioClases.findById(id);
	}
	
	@CacheEvict(allEntries=true)
	public void save(Clases clase) {
	    
		repositorioClases.save(clase);
	}
	
	@CacheEvict(allEntries=true)
	public void deleteById(long id) {
		
		repositorioClases.deleteById(id);
	}

	
}
