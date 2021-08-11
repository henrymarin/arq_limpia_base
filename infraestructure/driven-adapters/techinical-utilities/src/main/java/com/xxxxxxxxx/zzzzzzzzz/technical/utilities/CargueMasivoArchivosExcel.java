package com.xxxxxxxxx.zzzzzzzzz.technical.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Repository;

import com.xxxxxxxxx.zzzzzzzzz.domain.exception.JPARepositoryException;
import com.xxxxxxxxx.zzzzzzzzz.domain.util.CargueMasivoDto;
import com.xxxxxxxxx.zzzzzzzzz.domain.util.CargueMasivoRespuesta;
import com.xxxxxxxxx.zzzzzzzzz.domain.util.ExcelHandleRepositoryException;
import com.xxxxxxxxx.zzzzzzzzz.domain.util.ManejadorArchivosExcelRepository;
import com.xxxxxxxxx.zzzzzzzzz.domain.util.RestTemplateAdapterException;

@Repository
public class CargueMasivoArchivosExcel implements ManejadorArchivosExcelRepository {

	private static final int SIETE_L = 7;

	@Override
	public CargueMasivoRespuesta abrirArchivoProtegido(File archivo, String claveDelArchivo, CargueMasivoDto dto)
			throws ExcelHandleRepositoryException, RestTemplateAdapterException, JPARepositoryException {

		CargueMasivoRespuesta rta = new CargueMasivoRespuesta();
		try {
			try (Workbook workbook = WorkbookFactory.create(archivo, claveDelArchivo)) {
				Sheet cargue = workbook.getSheet("NOMBRE_LIBRO");
				Iterator<Row> iteratorCargue = cargue.iterator();
				while (iteratorCargue.hasNext()) {
					Row filaIterator = iteratorCargue.next();
					filaIterator.getCell(SIETE_L);
				}
			}
		} catch (IllegalStateException | IOException e) {
			throw new ExcelHandleRepositoryException("ERROR_CARGUE_MASIVO", e,
					ExcelHandleRepositoryException.Code.CARGA);
		}

		return rta;
	}
}
