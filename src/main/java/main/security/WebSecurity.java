package main.security;

import static main.security.Constants.LOGIN_URL;
import static main.security.Constants.REGISTER_URL;
import static main.security.Constants.ALLOWED_SWAGGER;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Arrays;


@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	private UserDetailsService userDetailsService;

	public WebSecurity(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		/*
		 * 1. Se desactiva el uso de cookies 2. Se activa la configuración CORS con los
		 * valores por defecto 3. Se desactiva el filtro CSRF 4. Se indica que el login
		 * no requiere autenticación 5. Se indica que el resto de URLs esten securizadas
		 */
		httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().cors(withDefaults())
				.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, LOGIN_URL).permitAll()
				.antMatchers(HttpMethod.POST, REGISTER_URL).permitAll().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.antMatchers(HttpMethod.GET, ALLOWED_SWAGGER).permitAll()
				.anyRequest().authenticated().and()
				.addFilter(new JWTAuthenticationFilter(authenticationManager()))
				.addFilter(new JWTAuthorizationFilter(authenticationManager()));
		
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Se define la clase que recupera los usuarios y el algoritmo para procesar las
		// passwords
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();		
		configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT", "DELETE"));		 
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues().combine(configuration));		
		return source;
	}
}