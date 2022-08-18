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
import main.service.GrupoServiceImpl;

@RestController
@RequestMapping("/api")
public class GrupoController {

	@Autowired
	GrupoServiceImpl grupoServiceImpl;

	@GetMapping("/grupos")
	public List<Grupo> listarGrupos() {

		return grupoServiceImpl.listarGrupos();

	}

	@PostMapping("/grupos")
	public Grupo guardarGrupo(@RequestBody Grupo grupo) {

		return grupoServiceImpl.guardarGrupo(grupo);

	}

	@GetMapping("/grupos/{id}")
	public Grupo grupoXID(@PathVariable(name = "id") Long id) {
		Grupo grupoXID = new Grupo();
		
		grupoXID = grupoServiceImpl.grupoXID(id);
		
		System.out.println("Grupo XID: " + grupoXID);
		
		return grupoXID;
	}

	@PutMapping("/grupos/{id}")
	public Grupo actualizarGrupo(@PathVariable(name = "id") Long id, @RequestBody Grupo grupo) {

		Grupo grupo_seleccionado = new Grupo();
		Grupo grupo_actualizado = new Grupo();

		grupo_seleccionado = grupoServiceImpl.grupoXID(id);

		grupo_seleccionado.setNombre_grupo(grupo.getNombre_grupo());
		grupo_seleccionado.setJuego(grupo.getJuego());
		grupo_seleccionado.setDescripcion(grupo.getDescripcion());
		grupo_seleccionado.setUsuarios(grupo.getUsuarios());

		grupo_actualizado = grupoServiceImpl.actualizarGrupo(grupo_seleccionado);

		System.out.println("Grupo actualizado: " + grupo_actualizado);

		return grupo_actualizado;
	}

	@DeleteMapping("/grupos/{id}")
	public void eliminarGrupo(@PathVariable(name = "id") Long id) {

		grupoServiceImpl.eliminarGrupo(id);

	}

}
