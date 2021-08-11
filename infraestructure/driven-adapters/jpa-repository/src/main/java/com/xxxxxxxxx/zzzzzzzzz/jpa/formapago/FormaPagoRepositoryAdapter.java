package com.xxxxxxxxx.zzzzzzzzz.jpa.formapago;


import com.xxxxxxxxx.zzzzzzzzz.domain.formapago.FormaPago;
import com.xxxxxxxxx.zzzzzzzzz.domain.formapago.gateways.FormaPagoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * CLase para Forma de pago
 */
@Repository
public class FormaPagoRepositoryAdapter implements FormaPagoRepository {
    @Autowired
    private FormaPagoDataRepository repository;
    private final FormaPagoMapper mapper;

    public  FormaPagoRepositoryAdapter(FormaPagoMapper mapper) {
        this.mapper = mapper;
    }


    /**
     * Guardar una forma de pago
     * @param dto FormaPago
     * @return FormaPago
     */
    @Override
    public FormaPago save(FormaPago dto) {
        FormaPagoData cuentasBan = mapper.toEntity(dto);
        cuentasBan = repository.save(cuentasBan);
        return mapper.toDto(cuentasBan);
    }

    /**
     * Guardar una forma de pago
     * @param id del item
     * @return FormaPago
     */
    @Override
    public FormaPago findById(Long id) {
        FormaPagoData laEntidad = null;
        Optional<FormaPagoData> laEntidadOpt = repository.findById(id);
        if (laEntidadOpt.isPresent()) {
            laEntidad = laEntidadOpt.get();
        }
        return mapper.toDto(laEntidad);
    }

    /**
     * Borra una Forma de pago
     * @param id del item
     */
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public FormaPago findByNombre(String name) {
        FormaPagoData laEntidad = null;
        Optional<FormaPagoData> laEntidadOpt = repository.findByNombre(name);
        if (laEntidadOpt.isPresent()) {
            laEntidad = laEntidadOpt.get();
        }
        return mapper.toDto(laEntidad);
    }

    /**
     * Lista todas las formas de pago
     * @return  List<FormaPago>
     */
    @Override
    public List<FormaPago> findAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }


}
