package main.service;

import java.util.List;

import main.dto.Juego;

public interface IJuegoService {
	
	public List<Juego> listarJuegos();
	
	public Juego guardarJuego(Juego juego);
	
	public Juego juegoXID(Long id);
	
	public Juego actualizarJuego(Juego juego);
	
	public void eliminarJuego(Long id);
	
}
