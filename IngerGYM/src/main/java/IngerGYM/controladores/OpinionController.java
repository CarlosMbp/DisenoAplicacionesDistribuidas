package IngerGYM.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import IngerGYM.servicios.ServicioClientes;
import IngerGYM.servicios.ServicioOpiniones;
import IngerGYM.entidades.*;

@Controller
public class OpinionController {
	
	@Autowired
	private ComponenteCliente userComponent;
	@Autowired
	private ServicioOpiniones servicioOpiniones;
	@Autowired
	private ServicioClientes servicioClientes;
	
	@GetMapping("/opiniones/opinionEnviada")
	public String enviarOpinion(Model model,String opinion) {
		
		Cliente cliente= userComponent.getLoggedUser();
		Opinion opinionObjeto= new Opinion(opinion);
		
		servicioOpiniones.save(opinionObjeto);
		opinionObjeto.setCliente(servicioClientes.findById(cliente.getId()));
		servicioOpiniones.save(opinionObjeto);
		return "opinionEnviada";
	
	}
	
	@GetMapping("/opiniones")
	public String verOpiniones(Model model, HttpServletRequest request){
		
		List<Opinion> opiniones = servicioOpiniones.findAll();
		model.addAttribute("opinionesDisponibles",opiniones);
		
		return "opiniones";
	}
}
