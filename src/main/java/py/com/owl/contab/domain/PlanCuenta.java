package py.com.owl.contab.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PlanCuenta {

	@Id
	@GeneratedValue
	private Long id;
}
