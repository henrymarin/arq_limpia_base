package com.xxxxxxxxx.zzzzzzzzz.api.rest.util.errors;

import org.springframework.http.HttpHeaders;

/**
 * HeaderUtil
 * 
 * @author causacionYpagos
 *
 */
public final class HeaderUtil {

	private HeaderUtil() {
		// constructor vacio por regla de sonar
	}

	/**
	 * <p>
	 * createAlert.
	 * </p>
	 *
	 * @param applicationName a {@link java.lang.String} object.
	 * @param message         a {@link java.lang.String} object.
	 * @param param           a {@link java.lang.String} object.
	 * @return a {@link org.springframework.http.HttpHeaders} object.
	 */
	public static HttpHeaders createAlert(String applicationName, String message, String param) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("X-" + applicationName + "-alert", message);
		headers.add("X-" + applicationName + "-params", param);
		return headers;
	}

	/**
	 * <p>
	 * createEntityCreationAlert.
	 * </p>
	 *
	 * @param applicationName   a {@link java.lang.String} object.
	 * @param enableTranslation a boolean.
	 * @param entityName        a {@link java.lang.String} object.
	 * @param param             a {@link java.lang.String} object.
	 * @return a {@link org.springframework.http.HttpHeaders} object.
	 */
	public static HttpHeaders createEntityCreationAlert(String applicationName, String entityName, String param) {
		String message = applicationName + (".") + entityName + (".created");
		return createAlert(applicationName, message, param);
	}

	/**
	 * <p>
	 * createEntityUpdateAlert.
	 * </p>
	 *
	 * @param applicationName   a {@link java.lang.String} object.
	 * @param enableTranslation a boolean.
	 * @param entityName        a {@link java.lang.String} object.
	 * @param param             a {@link java.lang.String} object.
	 * @return a {@link org.springframework.http.HttpHeaders} object.
	 */
	public static HttpHeaders createEntityUpdateAlert(String applicationName, String entityName, String param) {
		String message = applicationName + "." + entityName + ".updated";
		return createAlert(applicationName, message, param);
	}

	/**
	 * <p>
	 * createEntityDeletionAlert.
	 * </p>
	 *
	 * @param applicationName   a {@link java.lang.String} object.
	 * @param enableTranslation a boolean.
	 * @param entityName        a {@link java.lang.String} object.
	 * @param param             a {@link java.lang.String} object.
	 * @return a {@link org.springframework.http.HttpHeaders} object.
	 */
	public static HttpHeaders createEntityDeletionAlert(String applicationName, String entityName, String param) {
		String message = applicationName + "." + entityName + ".deleted";
		return createAlert(applicationName, message, param);
	}


}
