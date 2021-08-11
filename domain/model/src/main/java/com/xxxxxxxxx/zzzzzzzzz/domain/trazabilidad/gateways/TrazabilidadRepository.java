package com.xxxxxxxxx.zzzzzzzzz.domain.trazabilidad.gateways;

import com.xxxxxxxxx.zzzzzzzzz.domain.exception.JPARepositoryException;
import com.xxxxxxxxx.zzzzzzzzz.domain.trazabilidad.Trazabilidad;

public interface TrazabilidadRepository {

	/**
	 * save
	 * @param dto to save
	 * @return dto saved
	 * @throws JPARepositoryException : ex
	 */
	Trazabilidad save(Trazabilidad dto) throws JPARepositoryException;
	
}
