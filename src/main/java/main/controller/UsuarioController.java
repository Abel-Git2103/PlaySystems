package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dao.IUsuarioDao;
import main.dto.Usuario;
import main.service.UsuarioServiceImpl;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	IUsuarioDao iUsuarioDao;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UsuarioController(IUsuarioDao iUsuarioDao, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.iUsuarioDao = iUsuarioDao;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@GetMapping("/response-entity-builder-with-http-headers")
	public ResponseEntity<String> usingResponseEntityBuilderAndHttpHeaders() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Baeldung-Example-Header", "Value-ResponseEntityBuilderWithHttpHeaders");

		return ResponseEntity.ok().headers(responseHeaders).body("Response with header using ResponseEntity");
	}
	
	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;

	@GetMapping("/usuarios")
	public List<Usuario> listarUsuario() {

		return usuarioServiceImpl.listarUsuario();
	}
	
	@PostMapping("/usuarios")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
		return usuarioServiceImpl.guardarUsuario(usuario);
	}

	@GetMapping("/usuarios/{id}")
	public Usuario usuarioXID(@PathVariable(name = "id") String id) {

		Usuario usuarioXID = new Usuario();

		usuarioXID = usuarioServiceImpl.usuarioXID(id);

		System.out.println("Usuario XID: " + usuarioXID);

		return usuarioXID;
	}
	
	@PutMapping("/usuarios/{id}")
	public Usuario actualizarUsuario(@PathVariable(name = "id") String id, @RequestBody Usuario usuario) {

		Usuario usuario_seleccionado = new Usuario();
		Usuario usuario_actualizado = new Usuario();

		usuario_seleccionado = usuarioServiceImpl.usuarioXID(id);

		usuario_seleccionado.setNombre(usuario.getNombre());
		usuario_seleccionado.setApellidos(usuario.getApellidos());
		usuario_seleccionado.setEmail(usuario.getEmail());
		usuario_seleccionado.setPassword(usuario.getPassword());
		usuario_seleccionado.setFoto_perfil(usuario.getFoto_perfil());
		usuario_seleccionado.setFecha_creacion(usuario.getFecha_creacion());
		usuario_seleccionado.setFecha_modificacion(usuario.getFecha_modificacion());
		usuario_seleccionado.setRole(usuario.getRole());
		usuario_seleccionado.setUsuario_steam(usuario.getUsuario_steam());
		usuario_seleccionado.setGrupo(usuario.getGrupo());
		usuario_seleccionado.setMensaje(usuario.getMensaje());
		
		usuario_actualizado = usuarioServiceImpl.actualizarUsuario(usuario_seleccionado);

		System.out.println("Usuario actualizado: " + usuario_actualizado);

		return usuario_actualizado;
	}

	@DeleteMapping("/usuarios/{id}")
	public void eliminarUsuario(@PathVariable(name = "id") String id) {

		usuarioServiceImpl.eliminarUsuario(id);
	}
}
