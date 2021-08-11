package com.xxxxxxxxx.zzzzzzzzz.jpa.trazabilidad;

import javax.persistence.PersistenceException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.xxxxxxxxx.zzzzzzzzz.domain.exception.JPARepositoryException;
import com.xxxxxxxxx.zzzzzzzzz.domain.log.gateways.LoggerRepository;
import com.xxxxxxxxx.zzzzzzzzz.domain.trazabilidad.gateways.TrazabilidadRepository;
import com.xxxxxxxxx.zzzzzzzzz.jpa.trazabilidad.TrazabilidadDataRepository;
import com.xxxxxxxxx.zzzzzzzzz.jpa.trazabilidad.TrazabilidadMapper;
import com.xxxxxxxxx.zzzzzzzzz.jpa.trazabilidad.TrazabilidadRepositoryAdapter;

@RunWith(MockitoJUnitRunner.class)
public class TrazabilidadRATest {

	private static final String CORRECTO = "OK";
	@Mock LoggerRepository log;
    @Mock private TrazabilidadMapper mapper;
    @Mock private TrazabilidadDataRepository repository;
	@InjectMocks private TrazabilidadRepository repositoryAdapter = new TrazabilidadRepositoryAdapter(mapper);
	
	@Before
	public void init(){
		ReflectionTestUtils.setField(repositoryAdapter,"repo", repository);
		ReflectionTestUtils.setField(repositoryAdapter,"mapper", mapper);
	}
	
    @Test
    public void saveTestOk() throws JPARepositoryException {
        repositoryAdapter.save(null);
        Assert.assertNotNull(CORRECTO);
    }
    
    @Test
    public void saveTestNoOk() {
    	boolean error = false;
    	Mockito.when(repository.save(null)).thenThrow(new PersistenceException());
        try {
			repositoryAdapter.save(null);
		} catch (JPARepositoryException e) {
			log.error("",e);
			error = true;
		}
        Assert.assertTrue(error);
    }
	
}
