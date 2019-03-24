package susalud.backend.dominio.sistema.registro.servicio;

import susalud.backend.dominio.sistema.exception.SistemaException;
import susalud.backend.dominio.sistema.registro.dto.UsuarioDto;

public interface RegistroServicio {

	public void registrarUsuario(UsuarioDto UsuarioDto) throws SistemaException;	
	
}
