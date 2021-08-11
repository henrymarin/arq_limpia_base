package com.xxxxxxxxx.zzzzzzzzz.jpa.trazabilidad;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.stereotype.Repository;

import com.xxxxxxxxx.zzzzzzzzz.domain.exception.JPARepositoryException;
import com.xxxxxxxxx.zzzzzzzzz.domain.exception.JPARepositoryException.Code;
import com.xxxxxxxxx.zzzzzzzzz.domain.trazabilidad.Trazabilidad;
import com.xxxxxxxxx.zzzzzzzzz.domain.trazabilidad.gateways.TrazabilidadRepository;

@Repository
public class TrazabilidadRepositoryAdapter implements TrazabilidadRepository {

	@Autowired private TrazabilidadDataRepository repo;
    private final TrazabilidadMapper mapper;

    public TrazabilidadRepositoryAdapter(TrazabilidadMapper mapper) {
        this.mapper = mapper;
    }
    
	@Override
	public Trazabilidad save(Trazabilidad dto) throws JPARepositoryException {
		try {
			TrazabilidadData data = mapper.toEntity(dto);
			data = repo.save(data);
			return mapper.toDto(data);
		} catch(PersistenceException e) {
			throw new JPARepositoryException(e.getMessage(), e, Code.TRANSACCIONAL);
		} catch(DataIntegrityViolationException e) {
			throw new JPARepositoryException(e.getMessage(), e, Code.INTEGRIDAD_DATOS);
		} catch(InvalidDataAccessResourceUsageException e) {
			throw new JPARepositoryException(e.getMessage(), e, Code.ESTRUCTURA_JPA);
		}
	}

}
