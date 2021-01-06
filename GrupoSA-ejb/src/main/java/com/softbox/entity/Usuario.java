/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author Tilted-Shugar
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="DTYPE",discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("U")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Usuario", length=30)
    private Long id_Usuario;
    @Column(name = "pass", nullable = false, length=50)
    private String pass;
    @Column(name = "email", nullable = false, length=50)
    private String email;
    @Enumerated(EnumType.STRING)
    private Rol_Perfil perfil;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

    public Long getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(Long id) {
        this.id_Usuario = id;
    }

    public Rol_Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Rol_Perfil perfil) {
        this.perfil = perfil;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_Usuario != null ? id_Usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id_Usuario == null && other.id_Usuario != null) || (this.id_Usuario != null && !this.id_Usuario.equals(other.id_Usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entrega_1.Usuario[ id=" + id_Usuario + " ]";
    }
    
}
