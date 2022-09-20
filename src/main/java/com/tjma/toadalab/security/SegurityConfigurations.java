package main.java.com.tjma.toadalab.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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
			auth.userDetailsService(autenticacaoService);
		} catch (Exception e) {
			System.out.println("Erro: "+e.getCause());
		}
	}

	//Controla as requisições
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET ,"/robos").permitAll()
		.antMatchers(HttpMethod.GET ,"/robos/*").permitAll()
		.antMatchers(HttpMethod.GET, "/execucoes").permitAll()
		.antMatchers(HttpMethod.GET, "/execucoes/*").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.csrf();
	}

	//Controla o acesso aos artefatos e recursos
	@Override
	public void configure(WebSecurity web) throws Exception {
		try {
			System.out.println("Rota não disponível!");
		} catch (Exception e) {
			System.out.println("Rota não disponível!");
		}
	}
	
	
}
