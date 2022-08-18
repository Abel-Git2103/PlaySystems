package main.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Grupo")
public class Grupo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_grupo")
	private Long id_grupo;

	@Column(name = "Nombre_grupo")
	private String nombre_grupo;

	@ManyToOne
	@JoinColumn(name = "Id_juego")
	private Juego juego;

	@Column(name = "Descripcion")
	private String descripcion;

	@OneToMany
	@JoinColumn(name = "Id_grupo")
	private List<Usuario> usuarios;

	public Grupo() {
		super();
	}

	public Grupo(Long id_grupo, String nombre_grupo, Juego juego, String descripcion) {
		super();
		this.id_grupo = id_grupo;
		this.nombre_grupo = nombre_grupo;
		this.juego = juego;
		this.descripcion = descripcion;
	}
	
	public Long getId_grupo() {
		return id_grupo;
	}

	public void setId_grupo(Long id_grupo) {
		this.id_grupo = id_grupo;
	}

	public String getNombre_grupo() {
		return nombre_grupo;
	}

	public void setNombre_grupo(String nombre_grupo) {
		this.nombre_grupo = nombre_grupo;
	}

	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Usuario")
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Grupo [id_grupo=" + id_grupo + ", nombre_grupo=" + nombre_grupo + ", juego=" + juego + ", descripcion="
				+ descripcion + "]";
	}

}