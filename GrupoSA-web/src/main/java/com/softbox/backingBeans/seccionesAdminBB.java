/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.backingBeans;

import com.softbox.ejb.SeccionFacadeLocal;
import com.softbox.entity.Seccion;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Borja Delgado
 */
@Named(value = "seccionesAdminBB")
@SessionScoped
public class seccionesAdminBB implements Serializable{
       
    private Seccion seccion = new Seccion();
    
    @Inject
    private SeccionFacadeLocal seccionEJB;
    

    /**
     * Creates a new instance of sociosBB
     */
    public seccionesAdminBB() {
    }

    public List<Seccion> getSecciones() {
        return seccionEJB.findAll();
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }
    
    //Accede a la vista de creación de eventos
    public String newSeccion(){
        seccion = new Seccion();
        return "crearSeccion.xhtml";
    }
    
    //Crea el evento con los datos proporcionado en la vista de creación
    public String createSeccion(){
        seccion.setId_seccion(seccionEJB.getNextId());
        seccionEJB.create(seccion);
        return "listarSecciones.xhtml";
    }
    
    public String modSeccion(Seccion soc){
        seccion = soc;
        return "modificarSeccion.xhtml";
    }
    public String updateSeccion(){
        seccionEJB.edit(seccion);
        return "listarSecciones.xhtml";
    }
    
    public String readSeccion(Seccion soc){
        seccion = soc;
        return "consultarSeccion.xhtml";
    }
    
}
