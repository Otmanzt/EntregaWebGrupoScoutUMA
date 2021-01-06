/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Usuario
 */
@Entity
public class Cuota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length=30)
    private Long id_Cuota;
    
    @Column(nullable=false,length=10)
    private Integer importe;
    
    @Column(nullable=false,length=50)
    private String nombre;
    
    @Column(nullable=false,length=200)
    private String descripcion;
    
    @OneToMany(mappedBy="cuota", cascade = {CascadeType.REMOVE})
    private List<Pago_Cuota> pago_cuotas;

    public Long getId_Cuota() {
        return id_Cuota;
    }

    public void setId_Cuota(Long id_Cuota) {
        this.id_Cuota = id_Cuota;
    }

    public Integer getImporte() {
        return importe;
    }

    public void setImporte(Integer importe) {
        this.importe = importe;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Pago_Cuota> getPago_cuotas() {
        return pago_cuotas;
    }

    public void setPago_cuotas(List<Pago_Cuota> pago_cuotas) {
        this.pago_cuotas = pago_cuotas;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_Cuota != null ? id_Cuota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuota)) {
            return false;
        }
        Cuota other = (Cuota) object;
        if ((this.id_Cuota == null && other.id_Cuota != null) || (this.id_Cuota != null && !this.id_Cuota.equals(other.id_Cuota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "trabajointernet.Cuota[ id=" + id_Cuota + " ]";
    }
    
}
