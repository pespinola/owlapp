package py.com.owl.owlapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.com.owl.owlapp.domain.Departamento;
import py.com.owl.owlapp.domain.Solicitante;
import py.com.owl.owlapp.repository.DepartamentoRepository;
import py.com.owl.owlapp.repository.SolicitanteRepository;

@RestController
@RequestMapping("solicitantes")
public class SolicitanteController extends GenericController<Solicitante> {
	@Autowired
	private SolicitanteRepository solicitanteRepo;
	@Autowired
	private DepartamentoRepository departamentoRepo;

	@Override
	public JpaRepository<Solicitante, Long> getRepository() {

		return solicitanteRepo;
	}

	@GetMapping("departamentos/{depId}")
	public ResponseEntity<List<Solicitante>> listaPorDep(@PathVariable Long depId) {
		Departamento departamento = departamentoRepo.findOne(depId);
		if (departamento == null) {
			logger.info("No existe departamento con id: " + depId);
			return ResponseEntity.noContent().build();
		}
		List<Solicitante> solicitantes = solicitanteRepo.findAllByDepartamento(departamento);
		return ResponseEntity.ok(solicitantes);
	}

}
