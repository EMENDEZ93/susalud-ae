package susalud.backend.dominio.sistema.rol.servicio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import susalud.backend.dominio.sistema.rol.constantes.RolArchivoConstante;
import susalud.backend.persistencia.sistema.rol.constantes.RolNombreConstante;
import susalud.backend.persistencia.sistema.rol.entidad.RolEntidad;
import susalud.backend.persistencia.sistema.rol.repositorio.RolEntidadRepositorio;

@Service
public class RolServicio {

	@Autowired
	private RolEntidadRepositorio rolEntidadRepositorio;

	public List<String> obtenerTodosRoles() throws InvalidFormatException, IOException {
		OPCPackage file = OPCPackage
				.open(new File(Paths.get("").toAbsolutePath().toString() + RolArchivoConstante.ROLES_ARCHIVO));

		XSSFWorkbook excel = new XSSFWorkbook(file);
		XSSFSheet sheet = excel.getSheetAt(RolArchivoConstante.ROLES_HOJA);
		Iterator<Row> rowIterator = sheet.iterator();

		Row row;
		List<String> allRole = new ArrayList<>();

		while (rowIterator.hasNext()) {
			row = rowIterator.next();
			allRole.add(row.getCell(0).toString());
		}

		return allRole;
	}

	public void cargarRoles() throws InvalidFormatException, IOException {
		obtenerTodosRoles().forEach(role -> {
			if (!rolEntidadRepositorio.existsByNombre(RolNombreConstante.valueOf(role))) {
				rolEntidadRepositorio.save(new RolEntidad(RolNombreConstante.valueOf(role)));
			}
		});
	}

}
