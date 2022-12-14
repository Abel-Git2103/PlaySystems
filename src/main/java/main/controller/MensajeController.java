package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.Grupo;
import main.dto.Mensaje;
import main.service.MensajeServiceImpl;

@RestController
@RequestMapping("/api")
public class MensajeController {

	@Autowired
	MensajeServiceImpl mensajeServiceImpl;
	
//	@Autowired
//	ChatServiceImpl chatServiceImpl;

	@GetMapping("/mensajes")
	public List<Mensaje> listarMensaje() {

		return mensajeServiceImpl.listarMensaje();
	}

	@PostMapping("/mensajes")
	public Mensaje guardarMensaje(@RequestBody Mensaje mensaje) {

		return mensajeServiceImpl.guardarMensaje(mensaje);
	}

	@GetMapping("/mensajes/{id}")
	public Mensaje mensajeXID(@PathVariable(name = "id") Integer id) {

		Mensaje mensajeXID = new Mensaje();

		mensajeXID = mensajeServiceImpl.mensajeXID(id);

		System.out.println("Mensaje XID: " + mensajeXID);

		return mensajeXID;
	}

	@GetMapping("/mensajes/grupo/{Id_Grupo}")
	public List<Mensaje> findByGrupo(@PathVariable(value = "Id_Grupo") Grupo Id_Grupo) {
		return mensajeServiceImpl.findByGrupo(Id_Grupo);
	}
	
	@PutMapping("/mensajes/{id}")
	public Mensaje actualizarMensaje(@PathVariable(name = "id") Integer id, @RequestBody Mensaje mensaje) {

		Mensaje mensaje_seleccionado = new Mensaje();
		Mensaje mensaje_actualizado = new Mensaje();

		mensaje_seleccionado = mensajeServiceImpl.mensajeXID(id);

		mensaje_seleccionado.setContenido(mensaje.getContenido());
		mensaje_seleccionado.setHora(mensaje.getHora());
		mensaje_seleccionado.setGrupo(mensaje.getGrupo());
		mensaje_seleccionado.setUsuario(mensaje.getUsuario());

		mensaje_actualizado = mensajeServiceImpl.actualizarMensaje(mensaje_seleccionado);

		System.out.println("Mensaje actualizado: " + mensaje_actualizado);

		return mensaje_actualizado;
	}

	@DeleteMapping("/mensajes/{id}")
	public void eliminarMensaje(@PathVariable(name = "id") Integer id) {

		mensajeServiceImpl.eliminarMensaje(id);
	}

}
