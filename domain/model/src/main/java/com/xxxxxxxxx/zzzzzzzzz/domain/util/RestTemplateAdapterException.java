package com.xxxxxxxxx.zzzzzzzzz.domain.util;

/**
 * RestTemplateAdapterException excepciones del consumo con Rest Template
 * @author causacion y pagos
 *
 */
public class RestTemplateAdapterException extends Exception{

	private static final long serialVersionUID = 1L;
	private final Code errorKey;

	public RestTemplateAdapterException(Code code) {
        super();
        this.errorKey = code;
    }
    public RestTemplateAdapterException(String message, Throwable cause, Code code) {
        super(message, cause);
        this.errorKey = code;
    }
    public RestTemplateAdapterException(String message, Code code) {
        super(message);
        this.errorKey = code;
    }
    public RestTemplateAdapterException(Throwable cause, Code code) {
        super(cause);
        this.errorKey = code;
    }    

	public Code getErrorKey() {
		return errorKey;
	}
	
	public enum Code {
		HTTP_URL("error en la url de consumo", 610L),
		CAST_RESPONSE("error en el cast del response a la clase", 611L);

		private String ds =  "";
		private Long id = 0L;

		Code(String ds, Long id) {
			this.ds = ds;
			this.id = id;
		}

		public String getDs() {
			return ds;
		}

		public Long getId() {
			return id;
		}
    }
	
}
