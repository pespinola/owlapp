package py.com.owl.owlapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Diego Cerrano
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "permiso_nombre_uk", columnNames = "nombre"))
public class Permiso {

	/**
	 *
	 */

	@Id
	@GeneratedValue
	private Long id;

	@NotBlank
	@Size(max = 60)
	private String nombre;

	@NotBlank
	@Size(max = 100)
	private String descripcion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {

		return nombre;
	}

	public void setNombre(String nombre) {

		this.nombre = nombre;
	}

	public String getDescripcion() {

		return descripcion;
	}

	public void setDescripcion(String descripcion) {

		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Permiso [nombre=" + nombre + "]";
	}

}