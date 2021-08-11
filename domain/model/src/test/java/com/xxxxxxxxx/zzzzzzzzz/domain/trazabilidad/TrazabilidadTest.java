package com.xxxxxxxxx.zzzzzzzzz.domain.trazabilidad;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.xxxxxxxxx.zzzzzzzzz.domain.trazabilidad.Trazabilidad;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class TrazabilidadTest {

	@Test
    public void trazabilidadTest() {       
		Trazabilidad model = new Trazabilidad();
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
