package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IUsuarioDao;
import main.dto.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	IUsuarioDao iUsuarioDao;

	@Override
	public List<Usuario> listarUsuario() {
		return iUsuarioDao.findAll();
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		return iUsuarioDao.save(usuario);
	}

	@Override
	public Usuario usuarioXID(String id) {
		return iUsuarioDao.findById(id).get();
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		return iUsuarioDao.save(usuario);
	}

	@Override
	public void eliminarUsuario(String id) {
		iUsuarioDao.deleteById(id);
	}

}
