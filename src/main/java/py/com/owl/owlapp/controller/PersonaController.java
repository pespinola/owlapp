package py.com.owl.owlapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.com.owl.owlapp.domain.Persona;
import py.com.owl.owlapp.repository.PersonaRepository;

@RestController
@RequestMapping("personas")
public class PersonaController extends GenericController<Persona> {

	@Autowired
	private PersonaRepository repo;

	@Override
	public JpaRepository<Persona, Long> getRepository() {
		return repo;
	}

	// personas/buscar-por-cedula/123456
	@GetMapping("buscar-por-cedula/{cedula}")
	public ResponseEntity<Persona> buscarPorCedula(@PathVariable String cedula) {
		Persona per = repo.findByCedula(cedula);
		if (per == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(per);
	}
}
