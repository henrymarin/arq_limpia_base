package com.xxxxxxxxx.zzzzzzzzz.domain.formapago;

import org.junit.Assert;
import org.junit.Test;

import com.xxxxxxxxx.zzzzzzzzz.domain.formapago.FormaPago;

public class FormaPagoTest {
    @Test
    public void formaPagoTest() {
        FormaPago model = new FormaPago();
        model.setId(null);
        model.setDescripcion(null);
        model.setEstadoReg(false);
        model.setArchivo(null);
        model.setNombre(null);

        model.getArchivo();
        model.getNombre();
        model.getId();
        model.getDescripcion();
        model.isEstadoReg();
        model.getNumeroSolicitud();
        model.getUserName();
        model.getvista();
        
        Assert.assertNotNull(model.toString());
    }
}
