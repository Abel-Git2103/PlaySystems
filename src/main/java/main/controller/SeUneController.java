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

import main.dto.SeUne;
import main.dto.Usuario;
import main.service.SeUneServiceImpl;

@RestController
@RequestMapping("/api")
public class SeUneController {

	@Autowired
	SeUneServiceImpl seUneServiceImpl;

	@GetMapping("/seune")
	public List<SeUne> listarSeUne() {

		return seUneServiceImpl.listarSeUne();
	}

	@PostMapping("/seune")
	public SeUne guardarSeUne(@RequestBody SeUne seUne) {

		return seUneServiceImpl.guardarSeUne(seUne);
	}

	@GetMapping("/seune/{id}")
	public SeUne seUneXID(@PathVariable(name = "id") Integer id) {

		SeUne seUneXID = new SeUne();

		seUneXID = seUneServiceImpl.seUneXID(id);

		System.out.println("SeUne XID: " + seUneXID);

		return seUneXID;
	}
	
	@GetMapping("/seune/grupo/{Username}")
	public List<SeUne> findByChat(@PathVariable(value = "Username") Usuario Username) {
		return seUneServiceImpl.findByUsuario(Username);
	}

	@PutMapping("/seune/{id}")
	public SeUne actualizarSeUne(@PathVariable(name = "id") Integer id, @RequestBody SeUne seUne) {

		SeUne seUne_seleccionado = new SeUne();
		SeUne seUne_actualizado = new SeUne();

		seUne_seleccionado = seUneServiceImpl.seUneXID(id);

		seUne_seleccionado.setGrupo(seUne.getGrupo());
		seUne_seleccionado.setUsuario(seUne.getUsuario());

		seUne_actualizado = seUneServiceImpl.actualizarSeUne(seUne_seleccionado);

		System.out.println("SeUne actualizado: " + seUne_actualizado);

		return seUne_actualizado;
	}

	@DeleteMapping("/seune/{id}")
	public void eliminarSeUne(@PathVariable(name = "id") Integer id) {

		seUneServiceImpl.eliminarSeUne(id);
	}
}
