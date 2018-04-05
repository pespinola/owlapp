package py.com.owl.owlapp.security;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import py.com.owl.owlapp.domain.Permiso;
import py.com.owl.owlapp.domain.Usuario;

@Component
@SessionScope
public class SesionUsuario {
	private Usuario usuarioPorConfirmar;
	private List<Permiso> permisosPorConfirmar;
	private SesionInfo sesionInfo;

	public Usuario getUsuarioPorConfirmar() {
		return usuarioPorConfirmar;
	}

	public void setUsuarioPorConfirmar(Usuario usuarioPorConfirmar) {
		this.usuarioPorConfirmar = usuarioPorConfirmar;
	}

	public List<Permiso> getPermisosPorConfirmar() {
		return permisosPorConfirmar;
	}

	public void setPermisosPorConfirmar(List<Permiso> permisosPorConfirmar) {
		this.permisosPorConfirmar = permisosPorConfirmar;
	}

	public SesionInfo getSesionInfo() {
		return sesionInfo;
	}

	/**
	 * invocado desde {@link LoginSuccessHandler}, se asume que credenciales son
	 * correctas
	 */
	public void confirmar() {
		sesionInfo = new SesionInfo();
		sesionInfo.setUsuario(usuarioPorConfirmar);
		sesionInfo.setPermisos(permisosPorConfirmar);
		sesionInfo.setFechaHoraInicio(new Date());
	}

}
