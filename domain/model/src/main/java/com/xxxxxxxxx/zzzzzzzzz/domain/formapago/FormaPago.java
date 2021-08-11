package com.xxxxxxxxx.zzzzzzzzz.domain.formapago;

import com.xxxxxxxxx.zzzzzzzzz.domain.util.TrazableObject;

public class FormaPago extends TrazableObject{
    private static final Long NUM_SOL = 100001L;
	private Long id;
    private String descripcion;
    private String nombre;
    private String archivo;
    private boolean estadoReg;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstadoReg() {
        return estadoReg;
    }

    public void setEstadoReg(boolean estadoReg) {
        this.estadoReg = estadoReg;
    }

	@Override
	public String getUserName() {
		return "HmMarin";
	}

	@Override
	public Long getNumeroSolicitud() {
		return NUM_SOL;
	}

	@Override
	public String getvista() {
		return "ms-order-dinamicas-contables";
	}
}
