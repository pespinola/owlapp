package py.com.owl.owlapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.com.owl.owlapp.domain.Cargo;
import py.com.owl.owlapp.repository.CargoRepository;

@RestController
@RequestMapping("cargos")
public class CargoController extends GenericController<Cargo> {
	@Autowired
	private CargoRepository repo;

	@Override
	public JpaRepository<Cargo, Long> getRepository() {
		return repo;
	}
}
