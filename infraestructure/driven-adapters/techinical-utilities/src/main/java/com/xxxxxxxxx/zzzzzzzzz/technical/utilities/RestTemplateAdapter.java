package com.xxxxxxxxx.zzzzzzzzz.technical.utilities;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.xxxxxxxxx.zzzzzzzzz.domain.tecnical.gateways.RestTemplateRepository;

@Repository
public class RestTemplateAdapter implements RestTemplateRepository {

    private RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public Object getResponseGet(String uri, Class<?> cls) {
        return restTemplate.getForObject(uri, cls);
	}

	@Override
	public Object getResponsePost(String uri, Object o, Class<?> cls) {
		return restTemplate.postForObject(uri, o, cls);
	}

	@Override
	public void getResponsePut(String uri, Object o, Map<String, String> params) {
		restTemplate.put(uri, o, params);
	}


	@Override
	public Object postForObject(String endPoint, Object httpEntityObj, Class<?> responseType, HttpHeaders headers) {
		HttpEntity<Object> httpEntity = new HttpEntity<>(httpEntityObj, headers);
		return restTemplate.postForObject(endPoint, httpEntity, responseType);
	}
    
}
