package com.xxxxxxxxx.zzzzzzzzz.jpa.formapago;

import org.mapstruct.Mapper;

import com.xxxxxxxxx.zzzzzzzzz.domain.formapago.FormaPago;

@Mapper(componentModel = "spring")
public interface FormaPagoMapper  {
	
    FormaPago toDto(FormaPagoData formaPagoData);

    FormaPagoData toEntity(FormaPago formaPagoDTO);
}
