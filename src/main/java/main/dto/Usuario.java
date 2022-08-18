package main.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Usuario")
public class Usuario {

	@Id
	@Column(name = "Username")
	private String username;

	@Column(name = "Nombre")
	private String nombre;

	@Column(name = "Apellidos")
	private String apellidos;

	@Column(name = "Email")
	private String email;

	@Column(name = "Password")
	private String password;

	@Column(name = "Foto_perfil")
	private String foto_perfil;

	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name = "Fecha_creacion")
	private LocalDateTime fecha_creacion;

	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name = "Fecha_modificacion")
	private LocalDateTime fecha_modificacion;

	@Column(name = "Role")
	private String role;

	@Column(name = "Usuario_steam")
	private String usuario_steam;

	@OneToMany 
	@JoinColumn(name = "Username")
	private List<Grupo> grupo;

	@OneToMany
	@JoinColumn(name = "Username")
	private List<Mensaje> mensaje;

	@ManyToOne
	@JoinColumn(name = "Id_grupo")
	Grupo grupos;

	// CONSTRUCTORES
	public Usuario() {
	}

	/**
	 * @param username
	 * @param nombre
	 * @param apellidos
	 * @param email
	 * @param password
	 * @param foto_perfil
	 * @param fecha_creacion
	 * @param fecha_modificacion
	 * @param role
	 * @param usuario_steam
	 * @param grupo
	 * @param mensaje
	 * @param grupos
	 */
	public Usuario(String username, String nombre, String apellidos, String email, String password,
			String foto_perfil, LocalDateTime fecha_creacion, LocalDateTime fecha_modificacion, String role,
			String usuario_steam, Grupo grupos) {
		this.username = username;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.foto_perfil = foto_perfil;
		this.fecha_creacion = fecha_creacion;
		this.fecha_modificacion = fecha_modificacion;
		this.role = role;
		this.usuario_steam = usuario_steam;
		this.grupos = grupos;
	}

	// GETTERS Y SETTERS
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFoto_perfil() {
		return foto_perfil;
	}

	public void setFoto_perfil(String foto_perfil) {
		this.foto_perfil = foto_perfil;
	}

	public LocalDateTime getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(LocalDateTime fecha_creación) {
		this.fecha_creacion = fecha_creación;
	}

	public LocalDateTime getFecha_modificacion() {
		return fecha_modificacion;
	}

	public void setFecha_modificacion(LocalDateTime fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsuario_steam() {
		return usuario_steam;
	}

	public void setUsuario_steam(String usuario_steam) {
		this.usuario_steam = usuario_steam;
	}

	public Grupo getGrupos() {
		return grupos;
	}

	public void setGrupos(Grupo grupos) {
		this.grupos = grupos;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Grupo")
	public List<Grupo> getGrupo() {
		return grupo;
	}

	public void setGrupo(List<Grupo> grupo) {
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

	// METODO TO STRING
	@Override
	public String toString() {
		return "Usuario [username=" + username + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", email=" + email + ", password=" + password + ", foto_perfil=" + foto_perfil + ", fecha_creacion="
				+ fecha_creacion + ", fecha_modificacion=" + fecha_modificacion + ", role=" + role + ", usuario_steam="
				+ usuario_steam + ", grupos=" + grupos + "]";
	}

}