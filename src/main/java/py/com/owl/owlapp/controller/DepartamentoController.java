package py.com.owl.owlapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import py.com.owl.owlapp.domain.Departamento;
import py.com.owl.owlapp.repository.DepartamentoRepository;

@RestController
@RequestScope
@RequestMapping("departamentos")
public class DepartamentoController extends GenericController<Departamento> {
	@Autowired
	private DepartamentoRepository repo;

	@Override
	public JpaRepository<Departamento, Long> getRepository() {

		return repo;
	}
}
