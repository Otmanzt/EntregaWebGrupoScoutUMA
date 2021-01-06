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
public class Pago_Cuota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length=30)
    private Long id_Pago;
    
    @Column(nullable=false,length=100)
    private Float importe;
    
    @Column(nullable=false,length=10)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @ManyToOne
    private Cuota cuota;
    
    @ManyToOne
    private Socio socio;

    public Long getId_Pago() {
        return id_Pago;
    }

    public void setId_Pago(Long id_Pago) {
        this.id_Pago = id_Pago;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cuota getCuota() {
        return cuota;
    }

    public void setCuota(Cuota cuota) {
        this.cuota = cuota;
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
        hash += (id_Pago != null ? id_Pago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pago_Cuota)) {
            return false;
        }
        Pago_Cuota other = (Pago_Cuota) object;
        if ((this.id_Pago == null && other.id_Pago != null) || (this.id_Pago != null && !this.id_Pago.equals(other.id_Pago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "trabajointernet.Pago_Cuota[ id=" + id_Pago + " ]";
    }
    
}
