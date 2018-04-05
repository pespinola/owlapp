package py.com.owl.owlapp.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;

@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	/** @see {@link UserDetailsServiceImpl} */
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * Indicamos que será userDetailsService para buscar usuario y permisos. El
		 * password está encriptado en MD5
		 */
		auth.userDetailsService(userDetailsService).passwordEncoder(new Md5PasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry expression = http
				.authorizeRequests();

		http.exceptionHandling().authenticationEntryPoint(getAuthenticationEntryPoint());
		http.requestCache().disable();
		expression.antMatchers(HttpMethod.GET, "/usuarios/**").hasAuthority("Usuario_sel");

		expression.antMatchers(HttpMethod.GET, "/departamentos/**").hasAuthority("Departamento_sel");
		expression.antMatchers(HttpMethod.POST, "/departamentos/**").hasAuthority("Departamento_ins");
		expression.antMatchers(HttpMethod.DELETE, "/departamentos/**").hasAuthority("Departamento_del");

		expression.antMatchers(HttpMethod.GET, "/cargos/**").hasAuthority("Cargo_sel");
		expression.antMatchers(HttpMethod.POST, "/cargos/**").hasAuthority("Cargo_ins");
		expression.antMatchers(HttpMethod.DELETE, "/cargos/**").hasAuthority("Cargo_del");

		expression.antMatchers(HttpMethod.GET, "/tareas/**").hasAuthority("Tarea_sel");

		// Cross-origin resource sharing
		http.cors();
		// desabilitar Cross-site request forgery
		http.csrf().disable();
	}

	// Retornar 401 cuando usuario no esté autenticado
	private AuthenticationEntryPoint getAuthenticationEntryPoint() {

		return new AuthenticationEntryPoint() {

			@Override
			public void commence(HttpServletRequest request, HttpServletResponse response,
					AuthenticationException authException) throws IOException, ServletException {

				response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			}
		};
	}

}
