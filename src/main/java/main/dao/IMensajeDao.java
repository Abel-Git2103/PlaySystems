package main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import main.dto.Chat;
import main.dto.Mensaje;

public interface IMensajeDao extends JpaRepository<Mensaje, Integer> {
	
	@Query
	List<Mensaje> findByChat(@Param("Id_Chat")Chat Id_Chat);
}
