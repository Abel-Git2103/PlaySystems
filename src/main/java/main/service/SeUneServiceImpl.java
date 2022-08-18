package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.ISeUneDao;
import main.dto.SeUne;
import main.dto.Usuario;

@Service
public class SeUneServiceImpl implements ISeUneService {

	@Autowired
	ISeUneDao iSeUneDao;

	@Override
	public List<SeUne> listarSeUne() {
		return iSeUneDao.findAll();
	}

	@Override
	public SeUne guardarSeUne(SeUne seUne) {
		return iSeUneDao.save(seUne);
	}

	@Override
	public SeUne seUneXID(Integer id) {
		return iSeUneDao.findById(id).get();
	}

	@Override
	public SeUne actualizarSeUne(SeUne seUne) {
		return iSeUneDao.save(seUne);
	}

	@Override
	public void eliminarSeUne(Integer id) {
		iSeUneDao.deleteById(id);
	}

	@Override
	public List<SeUne> findByUsuario(Usuario Username) {
		return iSeUneDao.findByUsuario(Username);
	}

}
