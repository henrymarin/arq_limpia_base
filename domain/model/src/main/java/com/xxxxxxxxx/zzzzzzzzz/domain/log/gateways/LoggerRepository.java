package com.xxxxxxxxx.zzzzzzzzz.domain.log.gateways;

/**
 * Interface
 * @author causacionYpagos
 *
 */
public interface LoggerRepository {

	/**
	 * 
	 * @param message: lo que se quire loguear
	 */
	void debug(String message);
	
	/**
	 * 
	 * @param message: lo que se quire loguear
	 * @param ex: error
	 */
	void error(String message, Exception ex);
	
	/**
	 * 
	 * @param message: lo que se quire loguear
	 */
	void error(String message);
	
	/**
	 * 
	 * @param message: lo que se quire loguear
	 */
	void info(String message);


	/**
	 * 
	 * @param message: lo que se quire loguear
	 * @param ex: error
	 */
    void warn(String message, Exception ex);


    /**
     * 
     * @param message: lo que se quire loguear
     */
    void warn(String message);


    /**
     * 
     * @param message: lo que se quire loguear
     */
    void fatal(String message);


    /**
     * 
     * @param message: lo que se quire loguear
     * @param ex: error
     */
    void fatal(String message, Exception ex);
	
	
	
}
