package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Chat;

public interface IChatDao extends JpaRepository<Chat, Integer>{	

}
