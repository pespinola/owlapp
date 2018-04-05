package py.com.owl.owlapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "persona_cedula_uk", columnNames = "cedula"))
public class Persona {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull(message = "Ingrese cédula")
	@Size(max = 18, message = "Valor máximo permitido es 18")
	private String cedula;

	@NotNull(message = "Ingrese nombre")
	@Size(max = 100, message = "Valor máximo permitido es 100")
	private String nombre;

	@NotNull(message = "Ingrese apellido")
	@Size(max = 100, message = "Valor máximo permitido es 100")
	private String apellido;

	@Size(max = 100, message = "Valor máximo permitido es 100")
	private String direccion;

	public Persona() {

	}

	public Persona(Long id, String cedula, String nombre, String apellido) {
		super();
		this.id = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
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

	@Override
	public String toString() {
		return "Persona [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}

}
