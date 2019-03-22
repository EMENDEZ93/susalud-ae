package susalud.backend.persistencia.test.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import susalud.backend.persistencia.test.entidad.TestEntidad;

@Repository
public interface TestEntidadRespositorio extends JpaRepository<TestEntidad, Serializable> {

}
