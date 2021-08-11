package com.xxxxxxxxx.zzzzzzzzz.jpa.formapago;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "tbl_cyp_forma_pago")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Where(clause = "fpag_est_reg='1'")
public class FormaPagoData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fpag_id")
    private Long id;

    @Column(name = "fpag_descripcion")
    private String descripcion;

    @Column(name = "fpag_est_reg")
    private boolean estadoReg;

    @Column(name = "fpag_nombre")
    private String nombre;

    @Column(name = "fpag_archivo")
    private String archivo;

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstadoReg(boolean estadoReg) {
        this.estadoReg = estadoReg;
    }


    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isEstadoReg() {
        return estadoReg;
    }

}
