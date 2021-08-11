package com.xxxxxxxxx.zzzzzzzzz.technical.utilities;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.xxxxxxxxx.zzzzzzzzz.domain.formapago.FormaPago;
import com.xxxxxxxxx.zzzzzzzzz.technical.utilities.RestTemplateAdapter;

@RunWith(MockitoJUnitRunner.class)
public class RestTemplateAdapterTest {

    private static final String HTTP_URI = "http://uri";
	@Mock private RestTemplate restTemplate;
    @InjectMocks RestTemplateAdapter restTemplateAdapter;
    
	@Test
	public void testGetResponseGet() {
        FormaPago rta = (FormaPago) restTemplateAdapter.getResponseGet(HTTP_URI, FormaPago.class);
		Assert.assertNull(rta);
	}
	
	@Test
	public void testGetResponsePost() {
		FormaPago rta = (FormaPago) restTemplateAdapter.getResponsePost(HTTP_URI, null, FormaPago.class);
		Assert.assertNull(rta);
	}
	
	@Test
	public void testGetResponsePut() {
        restTemplateAdapter.getResponsePut(HTTP_URI, null, null);
		Assert.assertTrue(true);
	}

}
