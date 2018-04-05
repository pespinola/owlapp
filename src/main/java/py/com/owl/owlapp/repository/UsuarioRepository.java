package py.com.owl.owlapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.owl.owlapp.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	// SELECT * FROM Usuario WHERE codigo = ?1
	Usuario findOneByCodigo(String codigo);
}
