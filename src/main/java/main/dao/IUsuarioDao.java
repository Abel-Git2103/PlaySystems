package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, String> {

	Usuario findByUsername(String username);
}
