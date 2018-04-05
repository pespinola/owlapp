package py.com.owl.owlapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "tiposervicio_nombre_uk", columnNames = "nombre"))
public class TipoTarea {
	@Id
	@GeneratedValue
	private Long id;

	@NotBlank(message = "Debe ingresar nombre")
	@Size(max = 60, message = "Solo se permite hasta 60 letras")
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
