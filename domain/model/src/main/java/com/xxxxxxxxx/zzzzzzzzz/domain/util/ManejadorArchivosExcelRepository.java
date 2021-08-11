package com.xxxxxxxxx.zzzzzzzzz.domain.util;

import java.io.File;

import com.xxxxxxxxx.zzzzzzzzz.domain.exception.JPARepositoryException;

public interface ManejadorArchivosExcelRepository {
	
	/**
	 * abririr Archivo Protegido
	 * @param archivoAEvaluar
	 * @param claveDelArchivo
	 * @param request 
	 * @return 
	 * @throws ExcelHandleRepositoryException 
	 * @throws RestTemplateAdapterException 
	 * @throws JPARepositoryException 
	 */
	CargueMasivoRespuesta abrirArchivoProtegido(File archivoAEvaluar, String claveDelArchivo, CargueMasivoDto request) 
			throws ExcelHandleRepositoryException, RestTemplateAdapterException, JPARepositoryException;

}
