package susalud.backend.dominio.sistema.builder.usuario;

import susalud.backend.dominio.sistema.registro.dto.UsuarioDto;
import susalud.backend.persistencia.sistema.usuario.entidad.UsuarioEntidad;

public final class UsuarioBuilder {

	private UsuarioBuilder() {
	}

	public static UsuarioEntidad convertirDtoAEntidad(UsuarioDto usuarioDto) {

		UsuarioEntidad usuariosEntidad = null;

		if (usuarioDto != null) {
			usuariosEntidad = new UsuarioEntidad();
			usuariosEntidad.setNombre(usuarioDto.getNombre());
			usuariosEntidad.setUsuario(usuarioDto.getUsuario());
			usuariosEntidad.setCorreo(usuarioDto.getCorreo());
		}

		return usuariosEntidad;
	}

}
