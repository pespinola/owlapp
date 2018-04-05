package py.com.owl.owlapp.domain;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * @author Diego Cerrano
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "rol_permiso_uk", columnNames = { "rol_id", "permiso_id" }))
public class RolPermiso {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@NotNull(message = "{rolPermiso.rol.notNull}")
	@JoinColumn(foreignKey = @ForeignKey(name = "rolpermiso_rol_fk"))
	private Rol rol;

	@ManyToOne
	@NotNull(message = "{rolPermiso.permiso.notNull}")
	@JoinColumn(foreignKey = @ForeignKey(name = "rolpermiso_permiso_fk"))
	private Permiso permiso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Rol getRol() {

		return rol;
	}

	public void setRol(Rol rol) {

		this.rol = rol;
	}

	public Permiso getPermiso() {

		return permiso;
	}

	public void setPermiso(Permiso permiso) {

		this.permiso = permiso;
	}

}