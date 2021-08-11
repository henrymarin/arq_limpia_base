package com.xxxxxxxxx.zzzzzzzzz.domain.tecnical.gateways;

import java.util.Map;

import org.springframework.http.HttpHeaders;

/**
 * Interface
 * @author causacionYpagos
 *
 */
public interface RestTemplateRepository {

	/**
	 * 
	 * @param uri url de consumo
	 * @param cls class de retorno
	 * @return the converted object
	 */
	Object getResponseGet(String uri, Class<?> cls);
	
	/**
	 * 
	 * @param url the URL
	 * @param request the Object to be POSTed (may be {@code null})
	 * @param responseType the type of the return value
	 * @return
	 */
	Object getResponsePost(String uri, Object o, Class<?> cls);
	
	/**
	 * 
	 * @param uri url de consumo
	 * @param cls class de retorno
	 */
	void getResponsePut(String uri, Object o, Map<String, String> params);


	/**
	 * Create a new resource by POSTing the given object to the URI template,
	 * and returns the representation found in the response.
	 * @param endPoint the URL
	 * @param httpEntity the Object to be POSTed (may be {@code null})
	 * @param responseType the type of the return value
	 * @param headers headers
	 * @return the converted object
	 */
	Object postForObject(String endPoint, Object httpEntity,Class<?> responseType, HttpHeaders headers);
	
	
}
