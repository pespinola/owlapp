package py.com.owl.owlapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import py.com.owl.owlapp.domain.Permiso;
import py.com.owl.owlapp.repository.PermisoRepository;

@RestController
@RequestScope
public class RolController {
	@Autowired
	private PermisoRepository permisoRepo;

	// 8080/owlback/roles/permisos/2
	@GetMapping("roles/permisos/{rolId}")
	public ResponseEntity<List<Permiso>> getPermisos(@PathVariable Long rolId) {

		return ResponseEntity.ok(permisoRepo.findAllByRol(rolId));
	}
}
