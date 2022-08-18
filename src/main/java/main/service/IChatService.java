package main.service;

import java.util.List;

import main.dto.Chat;

public interface IChatService {

	public List<Chat> listarChat();
	
	public Chat chatXID(Integer id);
	
	public Chat guardarChat(Chat chat);
			
	public Chat actualizarChat(Chat chat);
	
	public void eliminarChat(Integer id);
}
