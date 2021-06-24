package IngerGYM.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import IngerGYM.servicios.MailService;
import IngerGYM.servicios.ServicioClientes;
import IngerGYM.entidades.*;

@Controller
public class RegistroController {
	@Autowired 
	private MailService mail;

	@Autowired
	private ServicioClientes servicioClientes;
	
	@PostMapping("/registro")
	public String registrarse(@RequestParam String name,@RequestParam String email,@RequestParam int edad,@RequestParam String passwordHash){
		
		Cliente cliente= new Cliente(name,email,edad,passwordHash,"ROLE_USER");
		
		//Comprobamos si ya existe en la base de datos
		if(servicioClientes.findByNombre(cliente.getName()) != null) {
			return ("/errorRegistro");
	
		}else {
			String texto="Su registro con el nombre de usuario:"+name+" ha sido un éxito, ya puede disfrutar de IngerGym. Muchas gracias";
			Message m=new Message(email,"Registro completado en IngerGYM",texto);
			mail.sendMail(m);
			servicioClientes.save(cliente);
			return "usuarioRegistrado";	
			
		}
	}
	
    @GetMapping("/areaRegistro")
    public String areaRegistro(Model model, HttpServletRequest request) {
    	
    	return "registro";
    }
}


