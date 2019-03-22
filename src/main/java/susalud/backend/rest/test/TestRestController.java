package susalud.backend.rest.test;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import susalud.backend.dominio.test.dto.TestDto;
import susalud.backend.dominio.test.servicio.TestServicio;

@CrossOrigin
@RestController
@RequestMapping("api/test")
public class TestRestController {

	@Autowired
	private TestServicio testServicio;

	@GetMapping
	public String test() {
		return "** Su salud **";
	}

	@PostMapping
	public void ingresarTest(@Valid @RequestBody TestDto testDto) {
		testServicio.ingresarTest(testDto);
	}

	@DeleteMapping("/{idTest}")
	public void borrarTest(@PathVariable(value="idTest") int idTest ) {
		testServicio.borrarTest(idTest);
	}
	
}
