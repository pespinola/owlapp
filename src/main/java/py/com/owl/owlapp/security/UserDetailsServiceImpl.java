package py.com.owl.owlapp.security;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import py.com.owl.owlapp.domain.Permiso;
import py.com.owl.owlapp.domain.Usuario;
import py.com.owl.owlapp.repository.PermisoRepository;
import py.com.owl.owlapp.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final Logger logger = Logger.getLogger(getClass().getName());
	@Autowired
	private ApplicationContext appContext;
	@Autowired
	private UsuarioRepository usuarioRepo;
	@Autowired
	private PermisoRepository permisoRepo;

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		// buscamos usuario por su codigo
		Usuario usuario = usuarioRepo.findOneByCodigo(username);

		if (usuario == null) {
			throw new UsernameNotFoundException("No se encontró usuario");
		}

		return buildUserForAuthentication(usuario);
	}

	protected List<Permiso> getPermisos(Usuario usuario) {

		// usuario no tiene rol, se retorna lista de permisos vacía
		if (usuario.getRol() == null) {
			return new ArrayList<>();
		}
		// usuario tiene rol, se buscan los permisos por rol
		List<Permiso> permisos = permisoRepo.findAllByRol(usuario.getRol().getId());
		logger.info("Permisos de " + usuario + ": " + permisos);
		return permisos;
	}

	protected UserDetails buildUserForAuthentication(final Usuario usuario) {

		List<Permiso> permisos = getPermisos(usuario);
		// guardamos usuario
		SesionUsuario sesionUsuario = appContext.getBean(SesionUsuario.class);
		sesionUsuario.setUsuarioPorConfirmar(usuario);
		sesionUsuario.setPermisosPorConfirmar(permisos);

		List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
		/* Crear GrantedAuthority por cada Permiso */
		for (final Permiso permiso : permisos) {
			@SuppressWarnings("serial")
			GrantedAuthority ga = new GrantedAuthority() {

				@Override
				public String getAuthority() {

					return permiso.getNombre();
				}
			};
			grantedAuthorityList.add(ga);

		}

		return new User(usuario.getCodigo(), usuario.getPassword(), grantedAuthorityList);
	}
}
