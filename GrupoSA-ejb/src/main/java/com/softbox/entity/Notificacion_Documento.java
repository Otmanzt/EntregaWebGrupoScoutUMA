/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Access;
import javax.persistence.AccessType;
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
 * @author jesu
 */
@Entity
@Access (AccessType.FIELD)
public class Notificacion_Documento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_not_documento",length=30, nullable=false)
    private Long id_not_documento;
    @Temporal(TemporalType.DATE)
    @Column(nullable=false)
    private Date fechaNotificacion;
    @Column(name="Estado", length=10,nullable=false)
    private String estado;
    @ManyToOne
    private Socio socio;
    @ManyToOne
    private Documento documento;

    public Date getFechaNotificacion() {
        return fechaNotificacion;
    }

    public void setFechaNotificacion(Date fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }
    
    
    public Long getId_not_documento() {
        return id_not_documento;
    }
    
    public String getEstado(){
        return estado;
    }

    public void setId_not_documento(Long id) {
        this.id_not_documento = id_not_documento;
    }
    
    public void setEstado(String estado){
        this.estado=estado;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_not_documento != null ? id_not_documento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notificacion_Documento)) {
            return false;
        }
        Notificacion_Documento other = (Notificacion_Documento) object;
        if ((this.id_not_documento == null && other.id_not_documento != null) || (this.id_not_documento != null && !this.id_not_documento.equals(other.id_not_documento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entrega1_scouts.Notificacion_Documento[ id=" + id_not_documento + " ]";
    }
    
}
