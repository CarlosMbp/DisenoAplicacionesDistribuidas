package IngerGYM.controladores;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.web.csrf.CsrfToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import IngerGYM.entidades.Cliente;
import IngerGYM.entidades.Tarifa;
import IngerGYM.servicios.ServicioClientes;
import IngerGYM.servicios.ServicioOpiniones;
import IngerGYM.servicios.ServicioTarifas;

@Controller
public class WebController {
	
	@Autowired
	private ServicioClientes servicioCliente;
	
	@Autowired
	private ServicioOpiniones servicioOpiniones;
	
	@Autowired
	private ServicioTarifas servicioTarifas;
	
	@PostConstruct
	public void init() {
	}
	
	@GetMapping("/")
	public String mostrarPagPrincipal(){
		return "index";
	}
	
	@GetMapping("/login")
	public String loginAcceder(Model model, HttpServletRequest request) {
	
		return "login";
	}

    @GetMapping("/loginerror")
    public String loginerror() {
    	
    	return "loginerror";
    }
	
	@GetMapping("/bienvenido")
	public String login(Model model,HttpServletRequest request) {
		
		
		
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		return "bienvenidos";
	}
	
	
	
	@GetMapping("/usuariosDisponibles")
	public String listarUsuarios(Model model) {
	
		model.addAttribute("clientes",servicioCliente.findAll());
		
		return "usuariosDisponibles";
	}
	
	@GetMapping("/clientes/{id}")
	public String mostrarUsuario(Model model, @PathVariable long id) {

		model.addAttribute("cliente",servicioCliente.findById(id));
		model.addAttribute("clases",servicioCliente.findById(id).getClases());
		
		return "datosCliente";
	}
	
	@GetMapping("/clientes/{id}/darDeBaja")
	public String darDeBaja(Model model,HttpSession sesion, @PathVariable long id) {
	
		Cliente cliente=servicioCliente.findById(id);
		model.addAttribute("clienteActual",cliente);
		
		if(servicioOpiniones.deleteByUserId(id)==1) {
			return "eliminadoCorrectamente";
		}else {
			servicioCliente.deleteById(id);
			return "eliminadoCorrectamente";
		}
	}
	
	@GetMapping("/tarifa")
	public String tarifa(Model model) {
		
		model.addAttribute("tarifas",servicioTarifas.findAll());
		
		return "tarifa";
	}
	@GetMapping("/tarifas/{id}")
	public String tarifa2(Model model,HttpSession sesion,@PathVariable long id) {
	
		
		List<Tarifa> tarifas= servicioTarifas.findAll();
		List<Cliente> clientes= servicioCliente.findAll();
		List<Cliente> copia=new ArrayList<>();
		
		int edad=0;
		
		for(Tarifa f:tarifas) {
			if(f.getId()==id) {
				edad=f.getEdad();
				break;
			}
		}
		if(edad==24) {
			for(Cliente f:clientes) {
				if(f.getEdad()<25) {
					copia.add(f);
				}
			}
		}
		if(edad==64) {
			for(Cliente f:clientes) {
				if(f.getEdad()>=25&&f.getEdad()<65) {
					copia.add(f);
				}
			}
		}
		else {
			for(Cliente f:clientes) {
				if(f.getEdad()>=65) {
					copia.add(f);
				}
			}
		}
		
		model.addAttribute("clientes",copia);
		
		return "tarifaCopia";
	}
	
}