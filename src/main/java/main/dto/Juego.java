package main.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Juego")
public class Juego {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_juego")
	private Long id_juego;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Descripcion")
	private String descripcion;
	
	@Column(name="Imagen")
	private String imagen;
	
	@Column(name="Genero")
	private String genero;
	
	@OneToMany
	@JoinColumn(name="Id_juego")
	private List<Grupo> grupo;
	
	public Juego() {
	}

	public Juego(Long id_juego, String nombre, String descripcion, String imagen, String genero) {
		this.id_juego = id_juego;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.genero = genero;
	}

	public Long getId_juego() {
		return id_juego;
	}

	public void setId_juego(Long id_juego) {
		this.id_juego = id_juego;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Grupo")
	public List<Grupo> getGrupo() {
		return grupo;
	}

	public void setGrupo(List<Grupo> grupo) {
		this.grupo = grupo;
	}

	@Override
	public String toString() {
		return "Juego [id_juego=" + id_juego + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagen=" + imagen
				+ ", genero=" + genero + "]";
	}
	
}
