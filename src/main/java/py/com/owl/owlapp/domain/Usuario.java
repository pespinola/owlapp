package py.com.owl.owlapp.domain;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "usuario_codigo_uk", columnNames = { "codigo" }),
		@UniqueConstraint(name = "usuario_email_uk", columnNames = { "email" }) })
public class Usuario {

	@Id
	@GeneratedValue
	private Long id;

	@NotBlank(message = "{usuario.codigo.notBlank}")
	@Size(max = 20, message = "{usuario.codigo.size}")
	private String codigo;

	@JsonIgnore
	private String password;

	@NotBlank(message = "{usuario.nombre.notBlank}")
	@Size(max = 64, message = "{usuario.nombre.size}")
	private String nombres;

	@NotBlank(message = "{usuario.apellido.notBlank}")
	@Size(max = 64, message = "{usuario.apellido.size}")
	private String apellidos;

	@Email(message = "{invalid_email")
	@Size(max = 100, message = "{usuario.email.size}")
	private String email;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "usuario_rol_fk"))
	private Rol rol;

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

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public String getNombres() {

		return nombres;
	}

	public void setNombres(String nombres) {

		this.nombres = nombres;
	}

	public String getApellidos() {

		return apellidos;
	}

	public void setApellidos(String apellidos) {

		this.apellidos = apellidos;
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public Rol getRol() {

		return rol;
	}

	public void setRol(Rol rol) {

		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", nombres=" + nombres + ", apellidos=" + apellidos + "]";
	}

}
