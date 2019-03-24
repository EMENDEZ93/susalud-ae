package susalud.backend.dominio.sistema.sesion.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginDto {

	@NotBlank
	@Size(min = 3, max = 60)
	private String usuario;

	@NotBlank
	@Size(min = 6, max = 40)
	private String constrasena;

	public String getUsuario() {
		return usuario;
	}

	public String getConstrasena() {
		return constrasena;
	}

}
