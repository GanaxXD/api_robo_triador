package main.java.com.tjma.toadalab.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import main.java.com.tjma.toadalab.Models.Usuario;

@Service
public class AutenticacaoService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = new Usuario("toadalab@triador", "@T0@d@L@bTri4dor150621");
		return usuario;
	}

}
