/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Borja Delgado
 */

@Entity
public class Evento implements Serializable {
    
    //Atributos
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length=30, name="id_evento")
    private Long id_evento;
    @Column(nullable=false)
    private String nombre;
    @Column(nullable=false)
    private String descripcion;
    @Temporal(TemporalType.DATE)
    @Column(nullable=false)
    private Date fecha;
    @Column(nullable=false)
    private String localizacion;
    @Column(nullable=false)
    private Float precio;
    @Column(nullable=false)
    private String imagen;
    
    //Relaciones
    @ManyToOne
    private Seccion seccion;
    @ManyToMany
    @JoinTable(name = "ASISTENCIA", 
        joinColumns = @JoinColumn(name = "asistencia_evento_fk"),
        inverseJoinColumns = @JoinColumn(name = "asistencia_socio_fk"))
    private List<Socio> asistentes;
    @ManyToMany
    @JoinTable(name = "INSCRIPCION", 
        joinColumns = @JoinColumn(name = "inscripcion_evento_fk"),
        inverseJoinColumns = @JoinColumn(name = "inscripcion_socio_fk"))
    private List<Socio> inscritos;
    
    @OneToMany(mappedBy = "evento",cascade=CascadeType.REMOVE)
    private List<Notificacion_Evento> notificacionesEvento;
    
    @OneToMany(mappedBy = "evento",cascade=CascadeType.REMOVE)
    private List<Pago_Evento> pagosEvento;
    
    @OneToMany(mappedBy = "evento",cascade=CascadeType.REMOVE)
    private List<Comentario> comentariosEvento;    
    
    //Getters

    public Long getId_evento() {
        return id_evento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public Float getPrecio() {
        return precio;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public List<Socio> getAsistentes() {
        return asistentes;
    }

    public List<Socio> getInscritos() {
        return inscritos;
    }

    public List<Notificacion_Evento> getNotificacionesEvento() {
        return notificacionesEvento;
    }

    public List<Pago_Evento> getPagosEvento() {
        return pagosEvento;
    }

    public List<Comentario> getComentariosEvento() {
        return comentariosEvento;
    }

    public String getImagen() {
        return imagen;
    }

    //Setters
    public void setId_evento(Long id_evento) {
        this.id_evento = id_evento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public void setAsistentes(List<Socio> asistentes) {
        this.asistentes = asistentes;
    }

    public void setInscritos(List<Socio> inscritos) {
        this.inscritos = inscritos;
    }

    public void setNotificacionesEvento(List<Notificacion_Evento> notificacionesEvento) {
        this.notificacionesEvento = notificacionesEvento;
    }

    public void setPagosEvento(List<Pago_Evento> pagosEvento) {
        this.pagosEvento = pagosEvento;
    }

    public void setComentariosEvento(List<Comentario> comentariosEvento) {
        this.comentariosEvento = comentariosEvento;
    }
    
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    //HashCode, Equals y ToString
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_evento != null ? id_evento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.id_evento == null && other.id_evento != null) || (this.id_evento != null && !this.id_evento.equals(other.id_evento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entrega1_scouts.Evento[ id=" + id_evento + " ]";
    }
    
}
