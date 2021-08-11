package com.xxxxxxxxx.zzzzzzzzz.domain.exception;



/**
 * JPARepositoryException envuelve todas las excepciones de Java est�ndar comprobadas y las enriquece con un c�digo
 * de error personalizado.
 * @author causacion y pagos
 *
 */
public class JPARepositoryException extends Exception{

    private static final long serialVersionUID = 1L;
    private final Code errorKey;

    public JPARepositoryException(Code code) {
        super();
        this.errorKey = code;
    }
    public JPARepositoryException(String message, Throwable cause, Code code) {
        super(message, cause);
        this.errorKey = code;
    }
    public JPARepositoryException(String message, Code code) {
        super(message);
        this.errorKey = code;
    }
    public JPARepositoryException(Throwable cause, Code code) {
        super(cause);
        this.errorKey = code;
    }

    public Code getErrorKey() {
        return errorKey;
    }

    public enum Code {
        TRANSACCIONAL("Error en un @Transaccional", 911L),
        JPA("Error general en JPA", 912L),
        ESTRUCTURA_JPA("Error en columna JPA, clave foranea o estructura de consulta SQL", 913L),
        EXITOSO("Exitoso", 914L),
        PAGINADOR_SORT("Error en el parametro sort del paginador", 915L),
        PAGINADOR_NO_PARAMS("Error paginador sin parametros", 916L),
        INTEGRIDAD_DATOS("Error en nombre de una columna o inserccion de un null", 917L),
        ID_NO_EXISTE("Error no existe el id", 918L),
        ID_CREAR_REGISTRO("Id crear nuevo registro debe ser null", 918L),
        ID_ACTUALIZAR_REGISTRO("Id actualizar registro no puede ser null", 919L),
        IO_EXCEPTION("IOException generado", 920L);

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
    
    public enum CodeCargueMasivo {        
    	IO("IOException generado", 20L),
    	REST_T("RestTemplateException generado", 22L),
    	JPA("JPAException generado", 23L),
    	EXCEL("ExcelException generado", 21L);

        private String ds =  "";
        private Long id = 0L;

        CodeCargueMasivo(String ds, Long id) {
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
