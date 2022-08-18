package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.Chat;
import main.service.ChatServiceImpl;

@RestController
@RequestMapping("/api")
public class ChatController {

	@Autowired
	ChatServiceImpl chatServiceImpl;

	@GetMapping("/chats")
	public List<Chat> listarChat() {
		return chatServiceImpl.listarChat();
	}

	@GetMapping("/chats/{id}")
	public Chat chatXID(@PathVariable(name = "id") Integer id) {

		Chat chat_xid = new Chat();

		chat_xid = chatServiceImpl.chatXID(id);

		System.out.println("Chat XID: " + chat_xid);

		return chat_xid;
	}

	@PostMapping("/chats")
	public Chat guardarChat(@RequestBody Chat chat) {

		return chatServiceImpl.guardarChat(chat);
	}

	@PutMapping("/chats/{id}")
	public Chat actualizarChat(@PathVariable(name = "id") Integer id, @RequestBody Chat chat) {

		Chat chat_seleccionada = new Chat();
		Chat chat_actualizada = new Chat();

		chat_seleccionada = chatServiceImpl.chatXID(id);		

		chat_seleccionada.setGrupo(chat.getGrupo());
		
		chat_actualizada = chatServiceImpl.actualizarChat(chat_seleccionada);

		System.out.println("La Chat actualizada es: " + chat_actualizada);

		return chat_actualizada;
	}

	@DeleteMapping("/chats/{id}")
	public void eliminarChat(@PathVariable(name = "id") Integer id) {
		chatServiceImpl.eliminarChat(id);
	}

}
