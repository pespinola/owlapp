package py.com.owl.owlapp.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import py.com.owl.owlapp.domain.Personal;
import py.com.owl.owlapp.repository.PersonalRepository;

@RestController
@RequestScope // @SessionScope, Singleton
@RequestMapping("personales")
public class PersonalController {
	protected Logger logger = Logger.getLogger(getClass().getName());
	@Autowired
	private PersonalRepository repo;

	public PersonalRepository getRepository() {
		return repo;
	}

	@GetMapping
	public ResponseEntity<List<Personal>> getList() {
		return ResponseEntity.ok(getRepository().findAll());
	}

	@PostMapping
	public ResponseEntity<Personal> insert(@Valid Personal entity) {
		logger.info("Guardando registro: " + entity);
		getRepository().save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}

	// /owlback/personales/7 -> DELETE
	@DeleteMapping("{id}")
	public ResponseEntity<Personal> delete(@PathVariable Long id) {
		logger.info("Buscando entidad con id: " + id);
		Personal entity = getRepository().findOne(id);
		if (entity == null) {
			logger.info("No se encontró personal con id: " + id);
			return ResponseEntity.status(HttpStatus.GONE).build();
		}
		logger.info("Borrando entidad: " + entity);
		getRepository().delete(entity);
		return ResponseEntity.ok(entity);
	}

}
