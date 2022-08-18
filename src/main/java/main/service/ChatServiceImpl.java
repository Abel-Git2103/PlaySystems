package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.IChatDao;
import main.dto.Chat;

@Service
public class ChatServiceImpl implements IChatService{

	@Autowired
	IChatDao iChatDao;
	
	@Override
	public List<Chat> listarChat() {
		
		return iChatDao.findAll();
	}

	@Override
	public Chat chatXID(Integer id) {
		
		return iChatDao.findById(id).get();
	}

	@Override
	public Chat guardarChat(Chat chat) {
		
		return iChatDao.save(chat);
	}

	@Override
	public Chat actualizarChat(Chat chat) {
		
		return iChatDao.save(chat);
	}

	@Override
	public void eliminarChat(Integer id) {
		
		iChatDao.deleteById(id);
	}

}
