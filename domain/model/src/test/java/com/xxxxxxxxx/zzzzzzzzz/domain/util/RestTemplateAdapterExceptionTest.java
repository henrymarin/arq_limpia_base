package com.xxxxxxxxx.zzzzzzzzz.domain.util;

import org.junit.Assert;
import org.junit.Test;

import com.xxxxxxxxx.zzzzzzzzz.domain.util.RestTemplateAdapterException;
import com.xxxxxxxxx.zzzzzzzzz.domain.util.RestTemplateAdapterException.Code;

public class RestTemplateAdapterExceptionTest {
	public static final String DESCRIPCION_ERROR = "Descripcion error";
	public static final String ERROR = "error x";
	
	@Test
	public void test1() {
		RestTemplateAdapterException e1 = new RestTemplateAdapterException(Code.HTTP_URL);
		Assert.assertNotNull(e1.getErrorKey());
	}
	
	@Test
	public void test2() {
		RestTemplateAdapterException e2 = new RestTemplateAdapterException(DESCRIPCION_ERROR, 
				new RuntimeException(ERROR), Code.HTTP_URL);
		Assert.assertNotNull(e2.getErrorKey());
	}
	
	@Test
	public void test3() {
		RestTemplateAdapterException e3 = new RestTemplateAdapterException(DESCRIPCION_ERROR, Code.HTTP_URL);
		Assert.assertNotNull(e3.getErrorKey());
	}
	
	@Test
	public void test4() {
		RestTemplateAdapterException e4 = new RestTemplateAdapterException(new RuntimeException(ERROR), Code.HTTP_URL);
		Assert.assertNotNull(e4.getErrorKey());
	}
	
	@Test
	public void test5() {
		Assert.assertNotNull(Code.HTTP_URL.getId() + Code.HTTP_URL.getDs());
	}

}
