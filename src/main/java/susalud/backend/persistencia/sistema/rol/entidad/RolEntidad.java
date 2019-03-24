package susalud.backend.persistencia.sistema.rol.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import susalud.backend.persistencia.sistema.rol.constantes.RolNombreConstante;

@Entity
@Table(name = "rol")
public class RolEntidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@NaturalId
	@Column(length = 60)
	private RolNombreConstante nombre;

	public RolEntidad() {
	}

	public RolEntidad(RolNombreConstante nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RolNombreConstante getNombre() {
		return nombre;
	}

	public void setNombre(RolNombreConstante nombre) {
		this.nombre = nombre;
	}

}
