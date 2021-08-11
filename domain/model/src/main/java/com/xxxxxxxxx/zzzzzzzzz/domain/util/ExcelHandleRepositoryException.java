package com.xxxxxxxxx.zzzzzzzzz.domain.util;

/**
 * ExcelHandleRepositoryException envuelve todas las excepciones de Java estándar comprobadas y 
 * las enriquece con un código de error personalizado. 
 * @author causacion y pagos
 *
 */
public class ExcelHandleRepositoryException extends Exception{

	private static final long serialVersionUID = 1L;
	private final Code errorKey;

	public ExcelHandleRepositoryException(Code code) {
        super();
        this.errorKey = code;
    }
    public ExcelHandleRepositoryException(String message, Throwable cause, Code code) {
        super(message, cause);
        this.errorKey = code;
    }
    public ExcelHandleRepositoryException(String message, Code code) {
        super(message);
        this.errorKey = code;
    }
    public ExcelHandleRepositoryException(Throwable cause, Code code) {
        super(cause);
        this.errorKey = code;
    }    

	public Code getErrorKey() {
		return errorKey;
	}
	
	public enum Code {
		CARGA("error en una cargue masivo", 710L),
		TRANSACCIONAL("error en una @Transaccional", 711L), 
		JPA("Erroe General", 712L);

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
