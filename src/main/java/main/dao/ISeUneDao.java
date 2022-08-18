package main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import main.dto.SeUne;
import main.dto.Usuario;

public interface ISeUneDao extends JpaRepository<SeUne, Integer> {

	@Query
	List<SeUne> findByUsuario(@Param("Username")Usuario Username);
}
