package susalud.backend.persistencia.sistema.rol.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import susalud.backend.persistencia.sistema.rol.constantes.RolNombreConstante;
import susalud.backend.persistencia.sistema.rol.entidad.RolEntidad;

@Repository
public interface RolEntidadRepositorio extends JpaRepository<RolEntidad, Long> {
	
	public Optional<RolEntidad> findByNombre(RolNombreConstante nombre);

	public abstract boolean existsByNombre(RolNombreConstante nombre);

}
