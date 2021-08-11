package com.xxxxxxxxx.zzzzzzzzz.domain.exception;

public class RespuestaTransaccion {

    private Long codigo;
    private String msgUsuario;
    private String msgTecnico;

    public RespuestaTransaccion() {
    	
	}
    
    public RespuestaTransaccion(Long i, String msgUsuario, String msgTecnico) {
    	this.codigo = i;
    	this.msgUsuario = msgUsuario;
    	this.msgTecnico = msgTecnico;    			
	}
    
    public Long getCodigo() {
        return codigo;
    }
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    public String getMsgUsuario() {
        return msgUsuario;
    }
    public void setMsgUsuario(String msgUsuario) {
        this.msgUsuario = msgUsuario;
    }
    public String getMsgTecnico() {
        return msgTecnico;
    }
    public void setMsgTecnico(String msgTecnico) {
        this.msgTecnico = msgTecnico;
    }

    /**
     * Metodo get respuesta transaccion
     * @param id id
     * @param msgUsuario mensaje de usuario
     * @param msgTecnico mensaje tecnico
     * @return RespuestaTransaccion respuesta transaccion
     */
    public static RespuestaTransaccion getRespuestaTransaccion(Long id, String msgUsuario, String msgTecnico) {
        RespuestaTransaccion respuestaTransaccion = new RespuestaTransaccion();
        respuestaTransaccion.setCodigo(id);
        respuestaTransaccion.setMsgUsuario(msgUsuario);
        respuestaTransaccion.setMsgTecnico(msgTecnico);
        return respuestaTransaccion;
    }
}
