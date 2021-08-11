package com.xxxxxxxxx.zzzzzzzzz.domain.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.xxxxxxxxx.zzzzzzzzz.domain.util.TrazableObject;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class TrazableObjectTest {

	@Test
    public void trazableObjectTest() {       
		TrazableObject model = Mockito.mock(TrazableObject.class,Mockito.CALLS_REAL_METHODS);	 
		model.getNumeroSolicitud();
		model.getUserName();
		model.getvista();
		model.obtenerJson();
        Assert.assertNotNull(model);
    }
	
	
}
