package py.com.owl.owlapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "personal_codigo_uk", columnNames = "codigo"))
public class Personal {

	@Id
	@GeneratedValue
	private Long id;

	@NotBlank(message = "{personal.codigo.notBlank}")
	@Size(max = 18, message = "{personal.codigo.size}")
	private String codigo;

	@NotBlank(message = "{personal.nombre.notBlank}")
	@Size(max = 100, message = "{personal.nombre.size}")
	private String nombre;

	@NotBlank(message = "{personal.apellido.notBlank}")
	@Size(max = 100, message = "{personal.apellido.size}")
	private String apellido;

	@Size(max = 100, message = "{personal.observacion.size}")
	private String observacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}
