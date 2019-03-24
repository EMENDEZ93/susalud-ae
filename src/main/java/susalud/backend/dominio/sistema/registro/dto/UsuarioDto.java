package susalud.backend.dominio.sistema.registro.dto;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank
	@Size(min = 3, max = 50)
	private String nombre;

	@NotBlank
	@Size(min = 3, max = 50)
	private String usuario;

	@NotBlank
	@Size(max = 60)
	@Email
	private String correo;

	private Set<String> rol;

	@NotBlank
	@Size(min = 6, max = 40)
	private String contrasena;

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

	public Set<String> getRol() {
		return rol;
	}

	public void setRol(Set<String> rol) {
		this.rol = rol;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

}
