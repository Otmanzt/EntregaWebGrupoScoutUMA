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
 * @author Borja Delgado
 */

@Entity
public class Notificacion_Evento implements Serializable {

    //Atributos
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_not_evento", length = 30)
    private Long id_not_evento;
    @Temporal(TemporalType.DATE)
    @Column(nullable=false)
    private Date fechaNotificacion;
    @Column(nullable=false)
    private String estado;
    
    //Relaciones
    @ManyToOne
    private Socio socio;
    @ManyToOne    
    private Evento evento;
    
    
   

    //Getters
    public Long getId_not_evento() {
        return id_not_evento;
    }

    public Date getFechaNotificacion() {
        return fechaNotificacion;
    }

    public String getEstado() {
        return estado;
    }

    public Socio getSocio() {
        return socio;
    }

    public Evento getEvento() {
        return evento;
    }


    //Setters
    public void setId_not_evento(Long id_notificacion_evento) {    
        this.id_not_evento = id_notificacion_evento;
    }

    public void setFechaNotificacion(Date fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public void setEvento(Evento evento) {    
        this.evento = evento;
    }

    //HashCode, Equals y ToString
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_not_evento != null ? id_not_evento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notificacion_Evento)) {
            return false;
        }
        Notificacion_Evento other = (Notificacion_Evento) object;
        if ((this.id_not_evento == null && other.id_not_evento != null) || (this.id_not_evento != null && !this.id_not_evento.equals(other.id_not_evento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entrega1_scouts.Notificacion_Evento[ id=" + id_not_evento + " ]";
    }
    
}
