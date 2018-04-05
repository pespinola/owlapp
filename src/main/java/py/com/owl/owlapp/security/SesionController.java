package py.com.owl.owlapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestScope
public class SesionController {
	@Autowired
	private SesionUsuario sesionUsuario;

	@GetMapping("sesion/info")
	public ResponseEntity<SesionInfo> info() {
		if (sesionUsuario.getSesionInfo() == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		} else {
			return ResponseEntity.ok(sesionUsuario.getSesionInfo());
		}
	}
}
