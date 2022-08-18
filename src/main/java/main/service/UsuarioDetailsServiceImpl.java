package main.service;

import static java.util.Collections.emptyList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import main.dao.IUsuarioDao;
import main.dto.Usuario;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {

	private IUsuarioDao iUsuarioDao;

	public UsuarioDetailsServiceImpl(IUsuarioDao iUsuarioDao) {
		this.iUsuarioDao = iUsuarioDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = iUsuarioDao.findByUsername(username);
		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(usuario.getUsername(), usuario.getPassword(), emptyList());
	}

}
