package com.bancolombia.causacionpagos.web.rest;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import com.xxxxxxxxx.zzzzzzzzz.api.rest.pago.FormasPagoService;
import com.xxxxxxxxx.zzzzzzzzz.api.rest.util.errors.BadRequestAlertException;
import com.xxxxxxxxx.zzzzzzzzz.domain.formapago.FormaPago;
import com.xxxxxxxxx.zzzzzzzzz.domain.formapago.gateways.FormaPagoRepository;
import com.xxxxxxxxx.zzzzzzzzz.domain.log.gateways.LoggerRepository;
import com.xxxxxxxxx.zzzzzzzzz.usecase.formapago.FormaPagoUseCase;

@RunWith(MockitoJUnitRunner.class)
public class FormaPServiceTest {

    private static final long DIEZ = 10L;
    @Mock FormaPagoRepository repository;
    @Mock LoggerRepository log;
    @InjectMocks private FormaPagoUseCase servicio = new FormaPagoUseCase(repository, log);
    FormasPagoService controladora = new FormasPagoService(servicio);

    
    @Before
    public void init() {
        ReflectionTestUtils.setField(servicio, "entityInterface", repository);
        ReflectionTestUtils.setField(servicio, "log", log);
    }

    @Test
    public void createClaseTestException() throws URISyntaxException {
        FormaPago dto = crearDto();
        try {
            controladora.createFormaPago(dto);
        } catch (BadRequestAlertException e) {
            Assert.assertNotNull(e);
        }
    }


    @Test
    public void ejecutaPertinenciasTestOk() throws URISyntaxException {
        FormaPago dto = crearDto();
        dto.setId(null);
        Mockito.when(repository.save(dto)).thenReturn(crearDto());
        ResponseEntity<FormaPago> objRespuesta = controladora.createFormaPago(dto);
        Assert.assertNotNull(objRespuesta.getBody());
    }

    @Test
    public void updateClaseTestException() throws URISyntaxException {
        try {
            FormaPago dto = crearDto();
            dto.setId(null);
            ResponseEntity<FormaPago> objRespuesta = controladora.updateFormaPago(dto);
            Assert.assertNotNull(objRespuesta.getBody().getId());
        } catch (BadRequestAlertException e) {
            Assert.assertNotNull(e);
        }
    }

    @Test
    public void updateClaseTestOk() throws URISyntaxException {
        FormaPago dto = crearDto();
        Mockito.when(repository.save(dto)).thenReturn(crearDto());
        ResponseEntity<FormaPago> objRespuesta = controladora.updateFormaPago(dto);
        Assert.assertNotNull(objRespuesta.getBody().getId());
    }

    @Test
    public void getClaseTestOk() throws URISyntaxException {
        Mockito.when(repository.findById(DIEZ)).thenReturn(crearDto());
        ResponseEntity<FormaPago> objRespuesta = controladora.getFormaPago(DIEZ);
        Assert.assertNotNull(objRespuesta);
    }

    @Test
    public void getClaseTestNoOk() throws URISyntaxException {
        Mockito.when(repository.findById(DIEZ)).thenReturn(null);
        ResponseEntity<FormaPago> objRespuesta = controladora.getFormaPago(DIEZ);
        Assert.assertNotNull(objRespuesta);
    }

    @Test
    public void deleteClaseTestNoOk() throws URISyntaxException {
        ResponseEntity<Void> objRespuesta = controladora.deleteFormaPago(DIEZ);
        Assert.assertNotNull(objRespuesta);
    }

    @Test
    public void getAllAllTestOk() throws URISyntaxException {
        Mockito.when(repository.findAll()).thenReturn((new ArrayList<>()));
        ResponseEntity<List<FormaPago>> objRespuesta = controladora.getAll();
        Assert.assertNotNull(objRespuesta.getBody().size());
    }

    @Test
    public void getAllTestFail() throws URISyntaxException {
        Mockito.when(repository.findAll()).thenThrow(new RuntimeException("error x"));
        ResponseEntity<List<FormaPago>> objRespuesta = controladora.getAll();
        Assert.assertNotNull(objRespuesta.getBody().size());
    }

    private FormaPago crearDto() {
        FormaPago dto = new FormaPago();
        dto.setId(DIEZ);
        return dto;
    }
}
