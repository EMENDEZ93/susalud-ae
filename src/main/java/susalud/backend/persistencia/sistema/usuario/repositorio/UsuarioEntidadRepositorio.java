package susalud.backend.persistencia.sistema.usuario.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import susalud.backend.persistencia.sistema.usuario.entidad.UsuarioEntidad;

@Repository
public interface UsuarioEntidadRepositorio extends JpaRepository<UsuarioEntidad, Long> {

	public Optional<UsuarioEntidad> findByUsuario(String usuario);

	public Boolean existsByUsuario(String usuario);

	public Boolean existsByCorreo(String correo);

}
