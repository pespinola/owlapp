package py.com.owl.owlapp.security;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import py.com.owl.owlapp.domain.Permiso;
import py.com.owl.owlapp.domain.Usuario;

public class SesionInfo {
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date fechaHoraInicio;
	private Usuario usuario;
	private List<Permiso> permisos;

	public Date getFechaHoraInicio() {
		return fechaHoraInicio;
	}

	public void setFechaHoraInicio(Date fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}

}
