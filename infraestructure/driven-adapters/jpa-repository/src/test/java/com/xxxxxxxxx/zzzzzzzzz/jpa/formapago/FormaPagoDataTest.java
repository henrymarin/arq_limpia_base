	package com.xxxxxxxxx.zzzzzzzzz.jpa.formapago;

import org.junit.Assert;
import org.junit.Test;

import com.xxxxxxxxx.zzzzzzzzz.jpa.formapago.FormaPagoData;

public class FormaPagoDataTest {

    @Test
    public void formaPagoDataTest(){
        FormaPagoData data = new FormaPagoData();
        data.setId(null);
        data.setNombre(null);
        data.setDescripcion(null);
        data.setArchivo(null);
        data.setEstadoReg(false);

        data.getId();
        data.getDescripcion();
        data.getArchivo();
        data.isEstadoReg();
        data.getNombre();
        Assert.assertNotNull(data.toString());
    }
}
