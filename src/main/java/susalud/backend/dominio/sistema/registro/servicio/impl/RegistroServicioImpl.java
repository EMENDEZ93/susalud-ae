package susalud.backend.dominio.sistema.registro.servicio.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import susalud.backend.dominio.sistema.builder.usuario.UsuarioBuilder;
import susalud.backend.dominio.sistema.exception.SistemaException;
import susalud.backend.dominio.sistema.registro.dto.UsuarioDto;
import susalud.backend.dominio.sistema.registro.servicio.RegistroServicio;
import susalud.backend.persistencia.sistema.rol.constantes.RolNombreConstante;
import susalud.backend.persistencia.sistema.rol.entidad.RolEntidad;
import susalud.backend.persistencia.sistema.rol.repositorio.RolEntidadRepositorio;
import susalud.backend.persistencia.sistema.usuario.entidad.UsuarioEntidad;
import susalud.backend.persistencia.sistema.usuario.repositorio.UsuarioEntidadRepositorio;

@Service
public class RegistroServicioImpl implements RegistroServicio {

	@Autowired
	private UsuarioEntidadRepositorio usuarioEntidadRepositorio;

	@Autowired
	private RolEntidadRepositorio rolEntidadRepositorio;

	@Autowired(required = false)
	private PasswordEncoder encoder;
	
	@Override
	public void registrarUsuario(UsuarioDto usuarioDto) throws SistemaException {
		existsByUserName(usuarioDto);
		existsByCorreo(usuarioDto);
		registrar(usuarioDto);
	}

	private void existsByCorreo(UsuarioDto usuarioDto) throws SistemaException {
		if (usuarioEntidadRepositorio.existsByCorreo(usuarioDto.getCorreo())) {
			throw new SistemaException("Fail -> Email is already in use!");
		}
	}

	private void existsByUserName(UsuarioDto usuarioDto) throws SistemaException {
		if (usuarioEntidadRepositorio.existsByUsuario(usuarioDto.getUsuario())) {
			throw new SistemaException("Fail -> Username is already taken!");
		}
	}

	private void AsignarRoles(Set<RolEntidad> roles, String rol) {
		switch (rol) {
		case "admin":
			RolEntidad adminRol = rolEntidadRepositorio.findByNombre(RolNombreConstante.ROLE_ADMIN)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
			roles.add(adminRol);
			break;
		default:
			RolEntidad userRole = rolEntidadRepositorio.findByNombre(RolNombreConstante.ROLE_USUARIO)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
			roles.add(userRole);
		}
	}

	public void registrar(UsuarioDto usuarioDto) {

		UsuarioEntidad usuario = UsuarioBuilder.convertirDtoAEntidad(usuarioDto);
		usuario.setRoles(obtenerRolesDesdeUsuarioDto(usuarioDto));
		usuario.setContrasena(encoder.encode(usuarioDto.getContrasena()));
		usuarioEntidadRepositorio.save(usuario);

	}

	public Set<RolEntidad> obtenerRolesDesdeUsuarioDto(UsuarioDto usuarioDto) {
		Set<String> rolesEnvidadosUsuarioDto = usuarioDto.getRol();
		Set<RolEntidad> roles = new HashSet<>();

		rolesEnvidadosUsuarioDto.forEach(rol -> {
			AsignarRoles(roles, rol);
		});

		return roles;
	}

//	public ResponseEntity<?> authenticate(LoginCommand loginCommand) {
//
//		Authentication authentication = authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(loginCommand.getUsername(), loginCommand.getPassword()));
//		
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		
//		String jwt = jwtProvider.generateJwtToken(authentication);
//		UserDetails userDetails = (UserDetails) authentication.getPrincipal(); 
//
//		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
//	}

}
