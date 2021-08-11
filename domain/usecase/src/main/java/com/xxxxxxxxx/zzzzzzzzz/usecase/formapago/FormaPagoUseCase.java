package com.xxxxxxxxx.zzzzzzzzz.usecase.formapago;

import com.xxxxxxxxx.zzzzzzzzz.domain.formapago.FormaPago;
import com.xxxxxxxxx.zzzzzzzzz.domain.formapago.gateways.FormaPagoRepository;
import com.xxxxxxxxx.zzzzzzzzz.domain.log.gateways.LoggerRepository;

import java.util.List;

public class FormaPagoUseCase {
    private final LoggerRepository log;
    private final FormaPagoRepository entityInterface;


    public FormaPagoUseCase(FormaPagoRepository entityInterface, LoggerRepository log) {
        super();
        this.log = log;
        this.entityInterface = entityInterface;
    }

    /**
     * Save a forma Pago.
     *
     * @param dto the entity to save.
     * @return the persisted entity.
     */
    public FormaPago save(FormaPago dto) {
        log.debug("Request to save forma Pago : {}" + dto);
        return entityInterface.save(dto);
    }


    /**
     * Get one forma Pago by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    public FormaPago findOne(Long id) {
        log.debug("Request to get forma Pago : {}" + id);
        return entityInterface.findById(id);
    }

    /**
     * Delete the forma pago by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete forma Pago : {}" + id);
        entityInterface.deleteById(id);
    }


    public List<FormaPago> findAll() {
        log.debug("Request to get all formaPagoDto");
        return entityInterface.findAll();
    }


}

