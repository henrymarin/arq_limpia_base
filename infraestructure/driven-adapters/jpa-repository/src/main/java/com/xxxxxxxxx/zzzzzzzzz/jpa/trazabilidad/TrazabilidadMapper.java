package com.xxxxxxxxx.zzzzzzzzz.jpa.trazabilidad;

import org.mapstruct.Mapper;

import com.xxxxxxxxx.zzzzzzzzz.domain.trazabilidad.Trazabilidad;



/**
 * Mapper TrazabilidadData - Trazabilidad
 */
@Mapper(componentModel = "spring")
public interface TrazabilidadMapper {

	Trazabilidad toDto(TrazabilidadData data);

	TrazabilidadData toEntity(Trazabilidad dto);

}
