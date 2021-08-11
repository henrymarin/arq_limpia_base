package com.xxxxxxxxx.zzzzzzzzz.jpa.trazabilidad;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.xxxxxxxxx.zzzzzzzzz.jpa.trazabilidad.TrazabilidadData;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class TrazabilidadDataTest {

	@Test
    public void trazabilidadTest() {       
		TrazabilidadData model = new TrazabilidadData();
		model.getFechaRegistro();
		model.getFuncionalidad();
		model.getId();
		model.getIp();
		model.getOperacion();
		model.getTabla();
		model.getUsuario();
		model.getValorAnterior();
		model.getValorNuevo();
		
		model.setFechaRegistro(null);
		model.setFuncionalidad(null);
		model.setId(null);
		model.setIp(null);
		model.setOperacion(null);
		model.setTabla(null);
		model.setUsuario(null);
		model.setValorAnterior(null);
		model.setValorNuevo(null);
        Assert.assertNotNull(model);
    }
	
}
