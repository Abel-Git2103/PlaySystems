package main.service;

import java.util.List;

import main.dto.Usuario;

public interface IUsuarioService {

	public List<Usuario> listarUsuario();

	public Usuario guardarUsuario(Usuario usuario);

	public Usuario usuarioXID(String id);

	public Usuario actualizarUsuario(Usuario usuario);

	public void eliminarUsuario(String id);
}
