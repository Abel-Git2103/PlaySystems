package main.service;

import java.util.List;

import main.dto.Grupo;
import main.dto.Mensaje;

public interface IMensajeService {

	public List<Mensaje> listarMensaje();
	
	public List<Mensaje> findByGrupo(Grupo Id_Grupo);
		
	public Mensaje guardarMensaje(Mensaje mensaje);
	
	public Mensaje mensajeXID(Integer id);
	
	public Mensaje actualizarMensaje(Mensaje mensaje);
	
	public void eliminarMensaje(Integer id);
}
