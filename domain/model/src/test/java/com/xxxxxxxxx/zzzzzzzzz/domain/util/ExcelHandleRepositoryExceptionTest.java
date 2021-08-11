package com.xxxxxxxxx.zzzzzzzzz.domain.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.xxxxxxxxx.zzzzzzzzz.domain.util.ExcelHandleRepositoryException;

@RunWith(MockitoJUnitRunner.class)
public class ExcelHandleRepositoryExceptionTest {
	
	ExcelHandleRepositoryException dto = new ExcelHandleRepositoryException("", null);
	
	@Test
    public void constructor1TestOk() {
		dto = new ExcelHandleRepositoryException("", null);
        Assert.assertNotNull(dto);
    }
	
	@Test
    public void constructor2TestOk() {
		dto = new ExcelHandleRepositoryException(null);
        Assert.assertNotNull(dto);
    }
	
	@Test
    public void constructor3TestOk() {
		dto = new ExcelHandleRepositoryException("", null, null);
        Assert.assertNotNull(dto);
    }

}
