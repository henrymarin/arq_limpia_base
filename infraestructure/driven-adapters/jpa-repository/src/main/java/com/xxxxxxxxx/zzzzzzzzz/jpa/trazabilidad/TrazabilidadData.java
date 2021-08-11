package com.xxxxxxxxx.zzzzzzzzz.jpa.trazabilidad;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_bas_log_funcional")
public class TrazabilidadData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOGFUN_ID")
	private Long id;

	@Column(name = "LOGFUN_FUNCIONALIDAD")
	private String funcionalidad;

	@Column(name = "LOGFUN_OPERACION")
	private String operacion;

	@Column(name = "LOGFUN_FECHA_REGISTRO")
	private LocalDateTime fechaRegistro;

	@Column(name = "LOGFUN_USUARIO")
	private String usuario;

	@Column(name = "LOGFUN_VALOR_ANTERIOR")
	private String valorAnterior;

	@Column(name = "LOGFUN_VALOR_NUEVO")
	private String valorNuevo;

	@Column(name = "LOGFUN_TABLA")
	private String tabla;

	@Column(name = "LOGFUN_IP_ORIGEN")
	private String ip;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFuncionalidad() {
		return funcionalidad;
	}

	public void setFuncionalidad(String funcionalidad) {
		this.funcionalidad = funcionalidad;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getValorAnterior() {
		return valorAnterior;
	}

	public void setValorAnterior(String valorAnterior) {
		this.valorAnterior = valorAnterior;
	}

	public String getValorNuevo() {
		return valorNuevo;
	}

	public void setValorNuevo(String valorNuevo) {
		this.valorNuevo = valorNuevo;
	}

	public String getTabla() {
		return tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "TrazabilidadData [id=" + id + ", funcionalidad=" + funcionalidad + ", operacion=" + operacion
				+ ", fechaRegistro=" + fechaRegistro + ", usuario=" + usuario + ", valorAnterior=" + valorAnterior
				+ ", valorNuevo=" + valorNuevo + ", tabla=" + tabla + ", ip=" + ip + "]";
	}

}
