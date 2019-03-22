package susalud.backend.dominio.test.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import susalud.backend.dominio.test.dto.TestDto;
import susalud.backend.dominio.test.servicio.TestServicio;
import susalud.backend.persistencia.test.entidad.TestEntidad;
import susalud.backend.persistencia.test.repositorio.TestEntidadRespositorio;

@Service
public class TestServicioImpl implements TestServicio {

	@Autowired
	private TestEntidadRespositorio testEntidadRespositorio;
	
	@Override
	public void ingresarTest(TestDto testDto) {

		System.out.println("***************************************");

		validarNombre(testDto);

		TestEntidad test = new TestEntidad();
		test.setNombre(testDto.getNombre());
		
		testEntidadRespositorio.save(test);
	}

	private void validarNombre(TestDto testDto) {
		if (testDto.getNombre() != null) {

			System.out.println(testDto.getNombre());
		} else {
			System.out.println("el nombre es un campo requerido");
		}
	}

	@Override
	public void borrarTest(int idTest) {
		testEntidadRespositorio.deleteById(idTest);
	}

}
