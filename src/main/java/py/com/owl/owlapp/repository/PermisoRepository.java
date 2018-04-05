package py.com.owl.owlapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import py.com.owl.owlapp.domain.Permiso;

public interface PermisoRepository extends JpaRepository<Permiso, Long> {
	// JPQL, no native query
	static final String sql = "SELECT object(P) " + " FROM Permiso AS P, RolPermiso AS RP "
			+ " WHERE P.id = RP.permiso.id  AND RP.rol.id = ?1";

	@Query(value = sql)
	List<Permiso> findAllByRol(Long rolId);

}
