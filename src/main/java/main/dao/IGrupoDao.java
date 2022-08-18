package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Grupo;

public interface IGrupoDao extends JpaRepository<Grupo, Long>{

}
