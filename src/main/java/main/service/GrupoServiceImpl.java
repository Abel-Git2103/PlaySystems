package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IGrupoDao;
import main.dto.Grupo;

@Service
public class GrupoServiceImpl implements IGrupoService{

	@Autowired
	IGrupoDao iGrupoDao;
	
	@Override
	public List<Grupo> listarGrupos() {
		
		return iGrupoDao.findAll();
	}

	@Override
	public Grupo guardarGrupo(Grupo grupo) {
		return iGrupoDao.save(grupo);
	}

	@Override
	public Grupo grupoXID(Long id) {
		return iGrupoDao.findById(id).get();
	}

	@Override
	public Grupo actualizarGrupo(Grupo grupo) {
		return iGrupoDao.save(grupo);
	}

	@Override
	public void eliminarGrupo(Long id) {
		
		iGrupoDao.deleteById(id);
		
	}
	
}
