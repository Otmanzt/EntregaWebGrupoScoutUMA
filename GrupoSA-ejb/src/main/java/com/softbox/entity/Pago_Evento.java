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
 * @author Tilted-Shugar
 */
@Entity
public class Pago_Evento implements Serializable {

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
    private Socio socio;
    @ManyToOne
    private Evento evento;

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }

    public Long getId_Pago() {
        return id_Pago;
    }

    public void setId_Pago(Long id_Pago) {
        this.id_Pago = id_Pago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
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
        if (!(object instanceof Pago_Evento)) {
            return false;
        }
        Pago_Evento other = (Pago_Evento) object;
        if ((this.id_Pago == null && other.id_Pago != null) || (this.id_Pago != null && !this.id_Pago.equals(other.id_Pago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entrega_1.Pago_Evento[ id=" + id_Pago + " ]";
    }
    
}
