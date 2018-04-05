package py.com.owl.owlapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.com.owl.owlapp.domain.Usuario;
import py.com.owl.owlapp.repository.UsuarioRepository;

@RestController
@RequestMapping("usuarios")
public class UsuarioController extends GenericController<Usuario> {
	@Autowired
	private UsuarioRepository repo;

	@Override
	public UsuarioRepository getRepository() {
		return repo;
	}

	@Override
	public ResponseEntity<Usuario> save(@Valid Usuario usuario) {
		// primero encriptar contraseña
		if (usuario.getPassword() != null) {
			String rawPass = usuario.getPassword();
			String pass = DigestUtils.md5DigestAsHex(rawPass.getBytes());
			usuario.setPassword(pass);
		}
		return super.save(usuario);
	}

	@GetMapping("buscar/{codigo}")
	public ResponseEntity<Usuario> buscar(@PathVariable String codigo) {
		return ResponseEntity.ok(repo.findOneByCodigo(codigo));
	}

}
