package com.xxxxxxxxx.zzzzzzzzz.api.rest.util;

import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * EndpointDocControllerService: EndpointDocControllerService
 * @author causacion y pagos
 *
 */
@RestController
public class EndpointDocControllerService {
	private final RequestMappingHandlerMapping handlerMapping;

	@Autowired
	public EndpointDocControllerService(RequestMappingHandlerMapping handlerMapping) {
		this.handlerMapping = handlerMapping;
	}

	/**
	 * obtenerListadoDeServiciosRest: obtenerListadoDeServiciosRest
	 * @return
	 */
	@GetMapping(value = "/lista")
	public ResponseEntity<String> obtenerListadoDeServiciosRest() {
		StringBuilder sb = new StringBuilder();
		for(Entry<RequestMappingInfo, HandlerMethod> item : this.handlerMapping.getHandlerMethods().entrySet()) {
	        for (String urlPattern : item.getKey().getPatternsCondition().getPatterns()) {
	        	sb.append("Método: " + item.getKey().getMethodsCondition() + " - " + urlPattern + "<br>");
	        }
		}
		return new ResponseEntity<>(sb.toString(), HttpStatus.OK);
	}
}
