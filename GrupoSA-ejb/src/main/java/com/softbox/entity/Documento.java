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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author miguel_martin
 */
@Entity
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id_documento",length =30)
    private Long id_documento;
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;
    @Column(name = "tipo", nullable = false, length = 40)
    private String tipo;
    @Column(name = "enlace", nullable = false, length = 100)
    private String enlace;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Enumerated(EnumType.STRING)
    private EstadoDoc estado;
    @ManyToOne
    private Socio socio;
    
    public Long getId_documento() {
        return id_documento;
    }

    public void setId_documento(Long id) {
        this.id_documento = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public EstadoDoc getEstado() {
        return estado;
    }

    public void setEstado(EstadoDoc estado) {
        this.estado = estado;
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

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_documento != null ? id_documento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.id_documento == null && other.id_documento != null) || (this.id_documento != null && !this.id_documento.equals(other.id_documento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entrega1_scouts.Documento[ id=" + id_documento + " ]";
    }
    
}
