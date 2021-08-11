package com.xxxxxxxxx.zzzzzzzzz.technical.utilities;

public interface Enums {

	enum TipoDocumentoCM {
		NULL("nulo", "no existe ds larga"), NIT("NIT", "NIT"), TARJETA_I("TI", "TARJETA IDENTIDAD"),
		CEDULA_C("CC", "CÉDULA DE CIUDADANÍA");

		private String dsCorta = "";
		private String dsLarga = "";

		TipoDocumentoCM(String dsCorta, String dsLarga) {
			this.dsCorta = dsCorta;
			this.dsLarga = dsLarga;
		}

		public String getDsCorta() {
			return dsCorta;
		}

		public String getDsLarga() {
			return dsLarga;
		}

		public static TipoDocumentoCM getByDsCorta(String dsCorta) {
			for (TipoDocumentoCM e : values()) {
				if (dsCorta.equals(e.dsCorta)) {
					return e;
				}
			}
			return NULL;
		}
	}
	
	//--
	enum NovedadesClasificadas {
		NULL("nulo", 0L), 
		CAUSACION("causacion", 1L), 
		RADICACION("radicacion", 2L),
		PERTINENCIA_DOCUMANTAL("radicacion/Pendiente pertinencia documental",3L),
		DOCUMENTACION_SOPORTE("radicacion/Documentacion soporte", 4L), 
		TERCERO("radicacion/Terceros", 5L), 
		FACTURA_EXTEMPORANEA("radicacion/Factura extemporonea", 6L),
		LISTA_DE_CONTROL("radicacion/Listas de Control", 7L),
		DUPLICIDAD_DE_FACTURAS("radicacion/Duplicidad de Facturas", 8L),
		LISTA_DE_CONTROL_ALERTA("radicacion/Listas de Control con Alerta", 9L),
		LISTA_DE_CONTROL_CON_BLOQUEO("radicacion/Listas de Control con Bloqueo", 10L),
		LISTA_DE_CONTROL_CON_RECHAZO("radicacion/Listas de Control con Rechazo", 11L),
		MOTOR_TERCERO_301("radicacion/radicacion/Terceros 301", 12L, "301"),
		MOTOR_TERCERO_302("radicacion/radicacion/Terceros 302", 13L, "302"),
		MOTOR_TERCERO_303("radicacion/radicacion/Terceros 303", 14L, "303"),
		MOTOR_TERCERO_304("radicacion/radicacion/Terceros 304", 15L, "304"),
		MOTOR_TERCERO_305("radicacion/radicacion/Terceros 305", 16L, "305");

		private String ds =  "";
		private Long id = 0L;
		private String codigoRta =  "";

		NovedadesClasificadas(String ds, Long id) {
			this.ds = ds;
			this.id = id;
		}
		
		NovedadesClasificadas(String ds, Long id, String codigoRta) {
			this.ds = ds;
			this.id = id;
			this.codigoRta = codigoRta;
		}

		public String getDs() {
			return ds;
		}

		public Long getId() {
			return id;
		}

		public String getCodigoRta() {
			return codigoRta;
		}

		public static NovedadesClasificadas getById(Long id) {
			for (NovedadesClasificadas e : values()) {
				if (id.equals(e.id)) {
					return e;
				}
			}
			return NULL;
		}
	}
	
	//--
	enum RespuestasListadDeControl {
		NULL("nulo", "nulo"), 
		SIN_BLOQUEO("N", "No se encuentra bloqueado"),
		ALERTA("A", "Alerta"),
		CON_BLOQUEO("B", "Bloqueo"),
		GESTIONADO("G", "Gestionado"),
		CON_RECHAZO("R", "Rechazado");

		private String rta 		= "";
		private String mensaje 	= "";

		RespuestasListadDeControl(String rta, String mensaje) {
			this.rta 	 = rta;
			this.mensaje = mensaje;
		}

		public String getRta() {
			return rta;
		}

		public String getMensaje() {
			return mensaje;
		}

		public static RespuestasListadDeControl getByRta(String rta) {
			for (RespuestasListadDeControl e : values()) {
				if (rta.equalsIgnoreCase(e.rta)) {
					return e;
				}
			}
			return NULL;
		}

	}

}
