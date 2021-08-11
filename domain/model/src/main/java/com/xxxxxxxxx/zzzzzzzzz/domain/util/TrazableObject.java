package com.xxxxxxxxx.zzzzzzzzz.domain.util;

import org.json.JSONObject;

public abstract class TrazableObject {

	public String obtenerJson(){
		JSONObject obj = new JSONObject(this);
		return obj.toString();
	}
	
	/**
	 * getUserName
	 * @return
	 */
	public abstract String getUserName();
	
	/**
	 * getNumeroSolicitud
	 * @return
	 */
	public abstract Long getNumeroSolicitud();
	
	/**
	 * getvista
	 * @return
	 */
	public abstract String getvista();
	
}
