package com.xxxxxxxxx.zzzzzzzzz.aspectos;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface Trazable {

	enum Operaciones{
		GUARDAR_SOLICITUD
	}
	
	public String getOperacion() 	default "";
	public String getModulo() 		default "";
	public String getDescripcion() 	default "";
	public String getTabla() 		default "";
}
