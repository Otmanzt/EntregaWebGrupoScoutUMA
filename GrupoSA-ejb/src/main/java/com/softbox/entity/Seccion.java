/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Borja Delgado
 */

@Entity
public class Seccion implements Serializable {

    //Atributos
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_seccion", length = 30)
    private Long id_seccion;
    @Column(nullable=false)
    private String nombre;
    @Column(nullable=false)
    private int edad_max;
    @Column(nullable=false)
    private int edad_min;
    @Column(nullable=false)
    private String descripcion;
    
    //Relaciones
    @OneToMany(mappedBy="seccion")
    private List<Evento> eventos;
    @OneToMany(mappedBy="seccion")
    private List<Socio> socios;
    

    //Getters
    public Long getId_seccion() {
        return id_seccion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad_max() {
        return edad_max;
    }

    public int getEdad_min() {
        return edad_min;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public List<Socio> getSocios() {
        return socios;
    }

    //Setters
    public void setId_seccion(Long id_seccion) {
        this.id_seccion = id_seccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad_max(int edad_max) {
        this.edad_max = edad_max;
    }

    public void setEdad_min(int edad_min) {
        this.edad_min = edad_min;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public void setSocios(List<Socio> socios) {
        this.socios = socios;
    }

    //HashCode, Equals y ToString
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_seccion != null ? id_seccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seccion)) {
            return false;
        }
        Seccion other = (Seccion) object;
        if ((this.id_seccion == null && other.id_seccion != null) || (this.id_seccion != null && !this.id_seccion.equals(other.id_seccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entrega1_scouts.Seccion[ id=" + id_seccion + " ]";
    }
    
}
