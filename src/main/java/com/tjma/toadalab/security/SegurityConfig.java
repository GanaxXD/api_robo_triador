package main.java.com.tjma.toadalab.security;

@EnableWebSecurity
@Configuration
public class SegurityConfig extends WebSecurityConfigurerAdapter{
	
	//Configura parte de autenticação e controle de login
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {}

	//Configura parte de autorização
	@Override
	protected void configure(HttpSecurity http) throws Exception {}

	//Configura ´parte de recursos estáticos
	@Override
	protected void configure(WebSecurity web) throws Exception {}
	
}
