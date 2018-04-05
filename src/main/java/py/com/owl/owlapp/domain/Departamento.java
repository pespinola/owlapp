package py.com.owl.owlapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "departamento_nombre_uk", columnNames = "nombre"))
public class Departamento {

	@Id
	@GeneratedValue // SELECT * FROM hibernate_sequence
	private Long id;

	@NotBlank(message = "{departamento.nombre.notBlank}")
	private String nombre;

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

}
