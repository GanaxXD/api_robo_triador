package main.java.com.tjma.toadalab.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import main.java.com.tjma.toadalab.Models.Usuario;

@EnableWebSecurity
@Configuration
public class SegurityConfigurations extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private AutenticacaoService autenticacaoService;
	
	//Controla a autenticação
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		try {
			auth.inMemoryAuthentication().withUser("toadalab@triador")
				.password("@T0@d@L@bTri4dor150621").roles("ADMIN");
		} catch (Exception e) {
			System.out.println("Erro: "+e.getCause());
		}
	}

	//Controla as requisições
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.authorizeRequests()
			.antMatchers(HttpMethod.GET ,"/robos").permitAll()
			.antMatchers(HttpMethod.GET ,"/robos/*").permitAll()
			.antMatchers(HttpMethod.GET, "/execucoes").permitAll()
			.antMatchers(HttpMethod.GET, "/execucoes/*").permitAll()
			.anyRequest().authenticated()
		.and()
			.httpBasic()
		.and()
			.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
