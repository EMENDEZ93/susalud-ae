package susalud.backend.dominio.test.servicio;

import susalud.backend.dominio.test.dto.TestDto;

public interface TestServicio {

	public void ingresarTest(TestDto testDto);
	
	public void borrarTest(int idTest);
	
}
