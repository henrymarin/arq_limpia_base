package com.bancolombia.causacionpagos.web.rest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.xxxxxxxxx.zzzzzzzzz.aspectos.Trazable;
import com.xxxxxxxxx.zzzzzzzzz.aspectos.TrazableAspect;
import com.xxxxxxxxx.zzzzzzzzz.domain.formapago.FormaPago;
import com.xxxxxxxxx.zzzzzzzzz.domain.trazabilidad.gateways.TrazabilidadRepository;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class TrazableAspectTest {

	@InjectMocks private TrazableAspect aspecto;
	@Mock private HttpServletRequest httpServletRequest;
	@Mock private TrazabilidadRepository trazabilidadRepo;
	
	@Before
	public void init(){
		ReflectionTestUtils.setField(aspecto,"httpServletRequest", httpServletRequest);
		ReflectionTestUtils.setField(aspecto,"trazabilidadRepo", trazabilidadRepo);
	}
	
	@Test
    public void trazableObjectTest() throws NoSuchMethodException, SecurityException {
		ProceedingJoinPoint joinPoint = mock(ProceedingJoinPoint.class);
		MethodSignature signature = mock(MethodSignature.class);		
		//--
		when(joinPoint.getSignature()).thenReturn(signature);
		when(joinPoint.getArgs()).thenReturn(listaDeObjs());
		Method metodo = myMethod();
		when(signature.getMethod()).thenReturn(metodo);
		//--
		aspecto.around(joinPoint);
        Assert.assertNotNull(joinPoint);
    }


	public Method myMethod() throws NoSuchMethodException, SecurityException {
        return getClass().getDeclaredMethod("someMethod");
    }

	@Trazable(getDescripcion="descripcion-x",getModulo="modulo-x",getOperacion="operacion-x",getTabla="tabla-x")
	public void someMethod() {
        //customize me to have these:
        //1. The parameters you want for your test
        //2. The return type you want for your test
        //3. The annotations you want for your test
    }

	private Object[] listaDeObjs() {
		FormaPago obj2 = new FormaPago();
		Object obj =  new Object();
		Object[] lista =  new Object[2];
		lista[0] = obj;
		lista[1] = obj2;
		return lista;
	}
	
}
