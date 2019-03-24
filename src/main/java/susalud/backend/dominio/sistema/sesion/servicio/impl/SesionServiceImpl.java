package susalud.backend.dominio.sistema.sesion.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import susalud.backend.dominio.sistema.sesion.dto.LoginDto;
import susalud.backend.dominio.sistema.sesion.servicio.SesionService;
import susalud.backend.rest.security.jwt.JwtProvider;
import susalud.backend.rest.security.message.JwtResponse;

@Service
public class SesionServiceImpl implements SesionService {

	@Autowired(required = false)
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@Override
	public ResponseEntity<?> autenticacion(LoginDto LoginDto) {
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(LoginDto.getUsuario(), LoginDto.getConstrasena()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal(); 

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
	}

}
