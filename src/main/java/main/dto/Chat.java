package main.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Chat")
public class Chat {

	// Atributos
	@Id
	@Column(name="Id_chat")
	private int id_chat;

	@OneToOne
	@JoinColumn(name = "Id_grupo")
	private Grupo grupo;
	
	@OneToMany
	@JoinColumn(name = "Id_chat")
	private List<Mensaje> mensaje;	

	// Constructores
	public Chat() {
	}

	public Chat(int id_chat) {
		this.id_chat = id_chat;
	}

	// Getters and Setters
	public int getId_chat() {
		return id_chat;
	}

	public void setId_chat(int id_chat) {
		this.id_chat = id_chat;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Mensaje")
	public List<Mensaje> getMensaje() {
		return mensaje;
	}

	public void setMensaje(List<Mensaje> mensaje) {
		this.mensaje = mensaje;
	}

	// ToString
	@Override
	public String toString() {
		return "Chat [id_chat=" + id_chat + "]";
	}
}