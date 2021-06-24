package IngerGYM.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import IngerGYM.entidades.Clases;
import IngerGYM.entidades.Cliente;
import IngerGYM.entidades.ComponenteCliente;
import IngerGYM.entidades.Salas;
import IngerGYM.repositorios.RepositorioClases;
import IngerGYM.repositorios.RepositorioClientes;
import IngerGYM.repositorios.RepositorioSalas;
import IngerGYM.servicios.*;

@Controller

public class ReservaController {

	@Autowired
	private ServicioClientes servicioCliente;
	@Autowired
	private ComponenteCliente userComponent;
	@Autowired
	private ServicioClases cl;
	@Autowired
	private RepositorioSalas salas;
	@Autowired
	private RepositorioClientes repo;
	
	@PostMapping("/reservarPiscina")
	public String reservarPiscina(Model model,@RequestParam int dia,@RequestParam int hora){
		
		long id= userComponent.getLoggedUser().getId();
		Cliente cliente= servicioCliente.findById(id);
		
		Salas s=new Salas();
		int d=dia;
		int h=hora-9;
		
		//Salas sala,String prof,String tipo,int dia, int hora
		List<Salas> lista= salas.findAll();
		for(Salas sala:lista) {
			if(sala.getNombre().equals("Piscina")) {
				s=sala;
				break;
			}
		}
	
		Clases aux=new Clases(s,"null","PiscinaLibre",d,hora);
		boolean hay=servicioCliente.reservarPiscina(dia, h);
		if(hay==true) {
		
			cl.save(aux);
			cliente.addClase(aux);
			repo.save(cliente);
			
			return "ReservaRealizada";
		}
		else {
			return "AforoTope";
		}
	}

	@PostMapping("/reservarGimnasio")
	public String reservarGimnasio(@RequestParam int dia,@RequestParam int hora){
		
		long id= userComponent.getLoggedUser().getId();
		Cliente cliente= servicioCliente.findById(id);
		
		Salas s=new Salas();
		int d=dia;
		int h=hora-9;
		
		//Salas sala,String prof,String tipo,int dia, int hora
		List<Salas> lista= salas.findAll();
		for(Salas sala:lista) {
			if(sala.getNombre().equals("Gym")) {
				s=sala;
				break;
			}
		}
		
		Clases aux=new Clases(s,"null","GimnasioLibre",d,hora);
		boolean hay=servicioCliente.reservarPiscina(dia, h);
		if(hay==true) {
		
			cl.save(aux);
			cliente.addClase(aux);
			repo.save(cliente);			
			
			return "ReservaRealizada";
		}
		else {
			
			return "AforoTope";
		}  
		
	}
	
	@GetMapping("/gimnasio")
	public String gimnasio(Model model,HttpServletRequest request) {

		return "gimnasio";
	}
	
	@GetMapping("/piscina")
	public String piscina (Model model,HttpServletRequest request) {

		return "piscina";
	}
	
	
}
