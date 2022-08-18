package main.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Se_une")
public class SeUne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_seune")
	private int id_seune;

	@ManyToOne
	@JoinColumn(name = "Id_grupo")
	Grupo grupo;

	@ManyToOne
	@JoinColumn(name = "Username")
	Usuario usuario;

	// CONSTRUCTORES
	public SeUne() {
	}

	/**
	 * @param id
	 * @param grupo
	 * @param usuario
	 */
	public SeUne(int id_seune, Grupo grupo, Usuario usuario) {
		this.id_seune = id_seune;
		this.grupo = grupo;
		this.usuario = usuario;
	}

	// GETTERS Y SETTERS
	public int getId_seune() {
		return id_seune;
	}

	public void setId_seune(int id) {
		this.id_seune = id;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
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
		return "SeUne [id_seune=" + id_seune + ", grupo=" + grupo + ", usuario=" + usuario + "]";
	}

}
