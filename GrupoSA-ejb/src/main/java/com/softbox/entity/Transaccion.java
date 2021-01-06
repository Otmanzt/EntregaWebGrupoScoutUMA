/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Usuario
 */
@Entity
public class Transaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length=30)
    private Long id_Transaccion;
    
    @Column(nullable=false, length=50)
    private String concepto;
    
    @Column(nullable=false,length=10)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @Column(nullable=false,length=100)
    private Float importe;
    
    
    @ManyToOne
    private Socio socio;

    public Long getId_Transaccion() {
        return id_Transaccion;
    }

    public void setId_Transaccion(Long id_Transaccion) {
        this.id_Transaccion = id_Transaccion;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    
    
    

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_Transaccion != null ? id_Transaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaccion)) {
            return false;
        }
        Transaccion other = (Transaccion) object;
        if ((this.id_Transaccion == null && other.id_Transaccion != null) || (this.id_Transaccion != null && !this.id_Transaccion.equals(other.id_Transaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "trabajointernet.Transaccion[ id=" + id_Transaccion + " ]";
    }
    
}
