package com.xxxxxxxxx.zzzzzzzzz.domain.formapago.gateways;

import java.util.List;

import com.xxxxxxxxx.zzzzzzzzz.domain.formapago.FormaPago;

public interface FormaPagoRepository {

    /**
     * findAll
     *
     * @return listado de items
     */
    List<FormaPago> findAll();

    /**
     * save
     *
     * @param model objeto de entrada
     * @return el dto de retorno
     */
    FormaPago save(FormaPago model);

    /**
     * findById
     *
     * @param id del item
     * @return el dto de retorno
     */
    FormaPago findById(Long id);

    /**
     * deleteById
     *
     * @param id del item
     */
    void deleteById(Long id);

    /**
     * findByNombre
     *
     * @param name del item
     * @return el dto de retorno
     */
    FormaPago findByNombre(String name);


}
