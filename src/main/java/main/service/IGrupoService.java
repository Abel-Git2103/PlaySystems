package main.service;

import java.util.List;

import main.dto.Grupo;

public interface IGrupoService {
	
	public List<Grupo> listarGrupos();
	
	public Grupo guardarGrupo(Grupo grupo);
	
	public Grupo grupoXID(Long id);
	
	public Grupo actualizarGrupo(Grupo grupo);
	
	public void eliminarGrupo(Long id);
	
}
