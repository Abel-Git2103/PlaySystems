package main.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Mensaje")
public class Mensaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_mensaje")
	private int id_mensaje;
	
	@Column(name="Contenido")
	private String contenido;
	
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	@Column(name="Hora")
	private LocalDateTime hora;

	@ManyToOne
	@JoinColumn(name = "Id_chat")
	private Chat chat;

	@ManyToOne
	@JoinColumn(name = "Username")
	private Usuario usuario;

	// CONSTRUCTORES
	public Mensaje() {
	}

	/**
	 * @param id
	 * @param contenido
	 * @param hora
	 * @param chat
	 * @param usuario
	 */
	public Mensaje(int id_mensaje, String contenido, LocalDateTime hora, Chat chat, Usuario usuario) {
		this.id_mensaje = id_mensaje;
		this.contenido = contenido;
		this.hora = hora;
		this.chat = chat;
		this.usuario = usuario;
	}

	// GETTERS Y SETTERS
	public int getId_mensaje() {
		return id_mensaje;
	}

	public void setId_mensaje(int id_mensaje) {
		this.id_mensaje = id_mensaje;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public LocalDateTime getHora() {
		return hora;
	}

	public void setHora(LocalDateTime hora) {
		this.hora = hora;
	}

	public Chat getChat() {
		return chat;
	}
	
	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	// METODO TO STRING
	@Override
	public String toString() {
		return "Mensaje [id_mensaje=" + id_mensaje + ", contenido=" + contenido + ", hora=" + hora + ", chat=" + chat
				+ ", usuario=" + usuario + "]";
	}

}