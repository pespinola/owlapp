package py.com.owl.owlapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.owl.owlapp.domain.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
