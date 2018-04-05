package py.com.owl.owlapp.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public abstract class GenericController<T> {
	protected Logger logger = Logger.getLogger(getClass().getName());

	public abstract JpaRepository<T, Long> getRepository();

	@PostMapping
	public ResponseEntity<T> save(@Valid T entity) {
		// boolean nuevoRegistro = entity
		logger.info("Guardando registro: " + entity);
		getRepository().save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}

	private void pausa() {/*
							 * try { Thread.sleep(2000); } catch (InterruptedException e) { // TODO
							 * Auto-generated catch block e.printStackTrace(); }
							 */
	}

	@GetMapping
	public ResponseEntity<List<T>> getList() {
		pausa();
		return ResponseEntity.ok(getRepository().findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<T> find(@PathVariable Long id) {
		T entity = getRepository().findOne(id);
		if (entity == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(entity);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<T> delete(@PathVariable Long id) {
		logger.info("Buscando entidad con id: " + id);
		T entity = getRepository().findOne(id);
		if (entity == null) {
			logger.info("No se encontró entidad con id: " + id);
			return ResponseEntity.status(HttpStatus.GONE).build();
		}
		logger.info("Borrando entidad: " + entity);
		getRepository().delete(entity);
		return ResponseEntity.ok(entity);
	}
}
