package com.xxxxxxxxx.zzzzzzzzz.api.rest.util.errors;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

/**
 * BadRequestAlertException
 * 
 * @author causacionYpagos
 *
 */
public class BadRequestAlertException extends AbstractThrowableProblem {

	private static final long serialVersionUID = 1L;
	private final String entityName;
	private final String errorKey;

	/**
	 * BadRequestAlertException
	 * @param defaultMessage mensaje por defecto
	 * @param entityName nombre de la entidad
	 * @param errorKey id del error
	 */
	public BadRequestAlertException(String defaultMessage, String entityName, String errorKey) {
		this(ErrorConstants.DEFAULT_TYPE, defaultMessage, entityName, errorKey);
	}

	/**
	 * BadRequestAlertException
	 * @param type tipo de url
	 * @param defaultMessage mensaje por defecto
	 * @param entityName nombre de la entidad
	 * @param errorKey id del error
	 */
	public BadRequestAlertException(URI type, String defaultMessage, String entityName, String errorKey) {
		super(type, defaultMessage, Status.BAD_REQUEST, null, null, null, getAlertParameters(entityName, errorKey));
		this.entityName = entityName;
		this.errorKey = errorKey;
	}

	/**
	 * getEntityName
	 * @return String
	 */
	public String getEntityName() {
		return entityName;
	}

	/**
	 * getErrorKey
	 * @return String
	 */
	public String getErrorKey() {
		return errorKey;
	}

	/**
	 * getAlertParameters
	 * @param entityName nombre de la entidad
	 * @param errorKey id del error
	 * @return Map<String, Object>
	 */ 
	private static Map<String, Object> getAlertParameters(String entityName, String errorKey) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("message", "error." + errorKey);
		parameters.put("params", entityName);
		return parameters;
	}

}
