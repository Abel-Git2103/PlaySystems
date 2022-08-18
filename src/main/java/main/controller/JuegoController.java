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

import main.dto.Juego;
import main.service.JuegoServiceImpl;

@RestController
@RequestMapping("/api")
public class JuegoController {

	@Autowired
	JuegoServiceImpl juegoServiceImpl;

	@GetMapping("/juegos")
	public List<Juego> listarJuegos() {

		return juegoServiceImpl.listarJuegos();

	}

	@PostMapping("/juegos")
	public Juego guardarJuego(@RequestBody Juego juego) {

		return juegoServiceImpl.guardarJuego(juego);

	}

	@GetMapping("/juegos/{id}")
	public Juego juegoXID(@PathVariable(name = "id") Long id) {
		Juego juegoXID = new Juego();

		juegoXID = juegoServiceImpl.juegoXID(id);

		System.out.println("Juego XID: " + juegoXID);

		return juegoXID;
	}

	@PutMapping("/juegos/{id}")
	public Juego actualizarGrupo(@PathVariable(name = "id") Long id, @RequestBody Juego juego) {

		Juego juego_seleccionado = new Juego();
		Juego juego_actualizado = new Juego();

		juego_seleccionado = juegoServiceImpl.juegoXID(id);
		
		juego_seleccionado.setDescripcion(juego.getDescripcion());
		juego_seleccionado.setGenero(juego.getGenero());
		juego_seleccionado.setGrupo(juego.getGrupo());
		juego_seleccionado.setImagen(juego.getImagen());
		juego_seleccionado.setNombre(juego.getNombre());

		juego_actualizado = juegoServiceImpl.actualizarJuego(juego_seleccionado);

		System.out.println("Juego actualizado: " + juego_actualizado);

		return juego_actualizado;
	}

	@DeleteMapping("/juegos/{id}")
	public void eliminarJuego(@PathVariable(name = "id") Long id) {

		juegoServiceImpl.eliminarJuego(id);

	}
	
}
