package IngerGYM.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import IngerGYM.servicios.ServicioClientes;

@Controller
public class SalasController {
	
	@Autowired
	private ServicioClientes servicioClientes;
	
	@PostMapping("/zumba")
	public String zumba(Model model)
	{
		int plazasDisponibles=servicioClientes.getPlazasZumba();
		model.addAttribute("aforo", plazasDisponibles);
		return "zumba";
	}
	
	@PostMapping("/aquagym")
	public String aquagym(Model model)
	{
		int plazasDisponibles=servicioClientes.getPlazasAquagym();
		model.addAttribute("aforo", plazasDisponibles);
		return "aquagym";
	}
	
	@GetMapping("/salas")
	public String salas() {

		return "sala";
	}
	
}