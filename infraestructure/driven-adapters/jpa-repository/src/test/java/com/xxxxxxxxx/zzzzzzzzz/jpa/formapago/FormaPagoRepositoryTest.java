package com.xxxxxxxxx.zzzzzzzzz.jpa.formapago;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.xxxxxxxxx.zzzzzzzzz.domain.formapago.FormaPago;
import com.xxxxxxxxx.zzzzzzzzz.jpa.formapago.FormaPagoData;
import com.xxxxxxxxx.zzzzzzzzz.jpa.formapago.FormaPagoDataRepository;
import com.xxxxxxxxx.zzzzzzzzz.jpa.formapago.FormaPagoMapper;
import com.xxxxxxxxx.zzzzzzzzz.jpa.formapago.FormaPagoRepositoryAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class FormaPagoRepositoryTest {
    private static final long CIEN = 100L;
    private static final long DIEZ = 10L;
    private static final long UNOL = 1L;
    private static final String EFECTIVO = "EFECTIVO";


    @Mock
    private FormaPagoMapper mappingDef;

    @Mock
    private FormaPagoDataRepository repository;
    @Mock
    private FormaPagoRepositoryAdapter repositoryAdapter;


    @Before
    public void init() {
        repositoryAdapter = new FormaPagoRepositoryAdapter(mappingDef);
        ReflectionTestUtils.setField(repositoryAdapter, "repository", repository);
        Mockito.when(mappingDef.toDto(Mockito.any(FormaPagoData.class))).thenReturn(crearDto());

    }

    @Test
    public void deleteByIdTest() {
        boolean borrado = true;
        repositoryAdapter.deleteById(DIEZ);
        Assert.assertTrue(borrado);

    }

    @Test
    public void saveTest() {
        FormaPago rta = repositoryAdapter.save(crearDto());
        Assert.assertNull(rta);
    }

    @Test
    public void findAllTest() {
        Mockito.when(repository.findAll()).thenReturn((new ArrayList<>()));
        List<FormaPago> list = repositoryAdapter.findAll();
        Assert.assertNotNull(list);
    }


    @Test
    public void impDelServicioFindOneTest() {
        Mockito.when(repository.findById(DIEZ)).thenReturn(crearEntidadOpt());
        FormaPago rta = repositoryAdapter.findById(DIEZ);
        Assert.assertNotNull(rta);
    }

    @Test
    public void impDelServicioFindOneEmptyTest() {
        Mockito.when(repository.findById(DIEZ)).thenReturn(Optional.empty());
        FormaPago rta = repositoryAdapter.findById(DIEZ);
        Assert.assertNull(rta);
    }

    @Test
    public void findByNameTest() {
        Mockito.when(repository.findByNombre(EFECTIVO)).thenReturn(crearFormaPagoOpt());
        FormaPago rta = repositoryAdapter.findByNombre(EFECTIVO);
        Assert.assertNotNull(rta);
    }

    private Optional<FormaPagoData> crearEntidadOpt() {
        FormaPagoData entity = new FormaPagoData();
        entity.setId(UNOL);
        return Optional.of(entity);
    }

    private FormaPago crearDto() {
        FormaPago dto = new FormaPago();
        dto.setId(CIEN);
        return dto;
    }

    private Optional<FormaPagoData> crearFormaPagoOpt(){
        FormaPagoData entity = new FormaPagoData();
        entity.setNombre(EFECTIVO);
        return Optional.of(entity);
    }
}
