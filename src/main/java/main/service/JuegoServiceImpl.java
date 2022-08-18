package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IJuegoDao;
import main.dto.Juego;

@Service
public class JuegoServiceImpl implements IJuegoService{
	
	@Autowired
	IJuegoDao iJuegoDao;
	
	@Override
	public List<Juego> listarJuegos() {
		
		return iJuegoDao.findAll();
	}

	@Override
	public Juego guardarJuego(Juego juego) {
		return iJuegoDao.save(juego);
	}

	@Override
	public Juego juegoXID(Long id) {
		return iJuegoDao.findById(id).get();
	}

	@Override
	public Juego actualizarJuego(Juego juego) {
		return iJuegoDao.save(juego);
	}

	@Override
	public void eliminarJuego(Long id) {
		
		iJuegoDao.deleteById(id);
		
	}
}
