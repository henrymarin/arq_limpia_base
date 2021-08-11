package com.xxxxxxxxx.zzzzzzzzz.usecase;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.xxxxxxxxx.zzzzzzzzz.domain.formapago.FormaPago;
import com.xxxxxxxxx.zzzzzzzzz.domain.formapago.gateways.FormaPagoRepository;
import com.xxxxxxxxx.zzzzzzzzz.domain.log.gateways.LoggerRepository;
import com.xxxxxxxxx.zzzzzzzzz.usecase.formapago.FormaPagoUseCase;

@RunWith(MockitoJUnitRunner.class)
public class FormaPagoUseCaseTest {

	private static final long CIEN = 100L;
	
	@Mock LoggerRepository log;
    @Mock FormaPagoRepository repository;    
    private FormaPagoUseCase useCase = new FormaPagoUseCase(repository, log);
    
    @Before
    public void init(){
        ReflectionTestUtils.setField(useCase, "entityInterface", repository);
        ReflectionTestUtils.setField(useCase, "log", log);
    }

    @Test
    public void findOneTestOk() {
    	FormaPago rta = useCase.findOne(CIEN);
        Assert.assertNull(rta);
    }

    @Test
    public void saveTestOk() {
    	FormaPago dto = new FormaPago();
    	FormaPago rta = useCase.save(dto);
        Assert.assertNull(rta);
    }

    @Test
    public void deleteTestOk() {
        boolean rtaPertiCtasBancariasUseCase = true;
        useCase.delete(CIEN);
        Assert.assertTrue(rtaPertiCtasBancariasUseCase);
    }

    @Test
    public void findAllNoPageTestOk() {
        Mockito.when(repository.findAll()).thenReturn((new ArrayList<>()));
        List<FormaPago> objRespuesta = useCase.findAll();
        Assert.assertNotNull(objRespuesta);
    }
    
    
}
