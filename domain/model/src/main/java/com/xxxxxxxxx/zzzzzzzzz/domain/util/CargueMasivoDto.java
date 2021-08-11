package com.xxxxxxxxx.zzzzzzzzz.domain.util;

import java.time.LocalDateTime;

public class CargueMasivoDto {

	private byte[] file;
	private Long codigoNegocio;
	private String nombreNegocio;
	private Long numeroOrden;
	private Long idGestor;
	private String tipoInstruccion;
	private String nombreArchivo;
	// --
	private String ordenDeOperacionCliente;
	private String idGestorSoli;
	private LocalDateTime fechaEnvio;
	private String totalTransacciones;
	private String valorBaseAcumulado;
	// --
	private String terceroId;
	private String terceroTipoId;
	// --
	private Long radicadoDetalleID;

	public String getTerceroId() {
		return terceroId;
	}

	public void setTerceroId(String terceroId) {
		this.terceroId = terceroId;
	}

	public String getTerceroTipoId() {
		return terceroTipoId;
	}

	public void setTerceroTipoId(String terceroTipoId) {
		this.terceroTipoId = terceroTipoId;
	}

	public String getOrdenDeOperacionCliente() {
		return ordenDeOperacionCliente;
	}

	public void setOrdenDeOperacionCliente(String ordenDeOperacionCliente) {
		this.ordenDeOperacionCliente = ordenDeOperacionCliente;
	}

	public String getIdGestorSoli() {
		return idGestorSoli;
	}

	public void setIdGestorSoli(String idGestorSoli) {
		this.idGestorSoli = idGestorSoli;
	}

	public String getTotalTransacciones() {
		return totalTransacciones;
	}

	public void setTotalTransacciones(String totalTransacciones) {
		this.totalTransacciones = totalTransacciones;
	}

	public String getValorBaseAcumulado() {
		return valorBaseAcumulado;
	}

	public void setValorBaseAcumulado(String valorBaseAcumulado) {
		this.valorBaseAcumulado = valorBaseAcumulado;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public Long getCodigoNegocio() {
		return codigoNegocio;
	}

	public void setCodigoNegocio(Long codigoNegocio) {
		this.codigoNegocio = codigoNegocio;
	}

	public String getNombreNegocio() {
		return nombreNegocio;
	}

	public void setNombreNegocio(String nombreNegocio) {
		this.nombreNegocio = nombreNegocio;
	}

	public Long getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(Long numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public Long getIdGestor() {
		return idGestor;
	}

	public void setIdGestor(Long idGestor) {
		this.idGestor = idGestor;
	}

	public String getTipoInstruccion() {
		return tipoInstruccion;
	}

	public void setTipoInstruccion(String tipoInstruccion) {
		this.tipoInstruccion = tipoInstruccion;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public LocalDateTime getFechaEnvio() {
		return fechaEnvio;
	}

	public Long getRadicadoDetalleID() {
		return radicadoDetalleID;
	}

	public void setRadicadoDetalleID(Long radicadoDetalleID) {
		this.radicadoDetalleID = radicadoDetalleID;
	}

	public void setFechaEnvio(LocalDateTime fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
}
