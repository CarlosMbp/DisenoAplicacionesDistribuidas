package IngerGYM.entidades;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;


@Component
@SessionScope
public class ComponenteCliente implements Serializable{

	private Cliente user;

	public Cliente getLoggedUser() {
		return user;
	}

	public void setLoggedUser(Cliente user) {
		this.user = user;
	}

	public boolean isLoggedUser() {
		return this.user != null;
	}

}

