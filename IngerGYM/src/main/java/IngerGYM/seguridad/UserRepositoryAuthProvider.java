package IngerGYM.seguridad;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import IngerGYM.entidades.Cliente;
import IngerGYM.entidades.ComponenteCliente;
import IngerGYM.repositorios.RepositorioClientes;

@Component
public class UserRepositoryAuthProvider implements AuthenticationProvider {

	@Autowired
	private RepositorioClientes userRepository;
	
	@Autowired
	private ComponenteCliente userComponent;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {


		String username = authentication.getName();
		String password = (String) authentication.getCredentials();

		Cliente user = userRepository.findByName(username);
		
		if (user == null) {
			throw new BadCredentialsException("User not found");
		}

		if (!new BCryptPasswordEncoder().matches(password, user.getPasswordHash())) {

			throw new BadCredentialsException("Wrong password");
		} else {

			userComponent.setLoggedUser(user);
			
			List<GrantedAuthority> roles = new ArrayList<>();
			for (String role : user.getRoles()) {
				roles.add(new SimpleGrantedAuthority(role));
			}

			return new UsernamePasswordAuthenticationToken(username, password, roles);
		}
	}

	@Override
	public boolean supports(Class<?> authenticationObject) {
		return true;
	}
	
}