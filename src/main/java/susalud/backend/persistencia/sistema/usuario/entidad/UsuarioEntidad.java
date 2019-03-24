package susalud.backend.persistencia.sistema.usuario.entidad;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.NaturalId;

import susalud.backend.persistencia.sistema.rol.entidad.RolEntidad;

@Entity
@Table(name = "usuario", uniqueConstraints = { @UniqueConstraint(columnNames = { "usuario" }),
		@UniqueConstraint(columnNames = { "correo" }) })
public class UsuarioEntidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min = 3, max = 50)
	private String nombre;

	@NotBlank
	@Size(min = 3, max = 50)
	private String usuario;

	@NaturalId
	@NotBlank
	@Size(max = 50)
	@Email
	private String correo;

	@NotBlank
	@Size(min = 6, max = 100)
	private String contrasena;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_roles", joinColumns = @JoinColumn(name = "usuario_entidad_id"), inverseJoinColumns = @JoinColumn(name = "roles_id"))
	private Set<RolEntidad> roles = new HashSet<>();

	public UsuarioEntidad() {
	}

	public UsuarioEntidad(String nombre, String usuario, String correo, String contrasena) {
		this.nombre = nombre;
		this.usuario = usuario;
		this.correo = correo;
		this.contrasena = contrasena;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Set<RolEntidad> getRoles() {
		return roles;
	}

	public void setRoles(Set<RolEntidad> roles) {
		this.roles = roles;
	}

}
