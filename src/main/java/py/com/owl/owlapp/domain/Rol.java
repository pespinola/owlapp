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
@Table(uniqueConstraints = @UniqueConstraint(name = "rol_codigo_uk", columnNames = "codigo"))
public class Rol {

	@Id
	@GeneratedValue
	private Long id;

	@NotBlank(message = "{rol.codigo.notBlank}")
	@Size(max = 16)
	private String codigo;

	@Size(max = 100)
	private String descripcion;

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

	public String getDescripcion() {

		return descripcion;
	}

	public void setDescripcion(String descripcion) {

		this.descripcion = descripcion;
	}

}
