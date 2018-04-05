package py.com.owl.owlapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.owl.owlapp.domain.Departamento;
import py.com.owl.owlapp.domain.Solicitante;

public interface SolicitanteRepository extends JpaRepository<Solicitante, Long> {
	// SELECT * FROM solicitante WHERE departamento = ?
	List<Solicitante> findAllByDepartamento(Departamento departamento);
}
