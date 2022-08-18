package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Juego;

public interface IJuegoDao extends JpaRepository<Juego, Long>{

}
