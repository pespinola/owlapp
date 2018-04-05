package py.com.owl.owlapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.owl.owlapp.domain.Personal;

public interface PersonalRepository extends JpaRepository<Personal, Long> {
	// SELECT * FROM personal WHERE codigo = ?
	Personal findByCodigo(String codigo);
}
