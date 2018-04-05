package py.com.owl.owlapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.owl.owlapp.domain.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

	// SELECT * FROM persona WHERE cedula='1234'
	Persona findByCedula(String cedula);

	// SELECT * FROM persona WHERE nombre='Juan' AND apellido='Perez'
	Persona findByNombreAndApellido(String nombre, String apellido);
}
