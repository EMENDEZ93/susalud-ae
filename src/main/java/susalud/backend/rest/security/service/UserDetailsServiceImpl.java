package susalud.backend.rest.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import susalud.backend.persistencia.sistema.usuario.entidad.UsuarioEntidad;
import susalud.backend.persistencia.sistema.usuario.repositorio.UsuarioEntidadRepositorio;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioEntidadRepositorio usuarioEntidadRepositorio;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UsuarioEntidad user = usuarioEntidadRepositorio.findByUsuario(username).orElseThrow(
				() -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));

		return UserPrinciple.build(user);
	}

}
