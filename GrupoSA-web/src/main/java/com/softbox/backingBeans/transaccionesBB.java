/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.backingBeans;

import com.softbox.ejb.TransaccionFacadeLocal;
import com.softbox.entity.Socio;
import com.softbox.entity.Transaccion;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Borja Delgado
 */
@Named(value = "transaccionesBB")
@SessionScoped
public class transaccionesBB implements Serializable{
    
    private Transaccion transaccion = new Transaccion();
    private Socio socio = new Socio();

    
    @Inject
    private TransaccionFacadeLocal transacEJB;
    
    /**
     * Creates a new instance of sociosBB
     */
    public transaccionesBB() {
    }

    public List<Transaccion> getTransacciones() {
        return transacEJB.findAll();
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }
    
    //Accede a la vista de creación de eventos
    public String newTransaccion(){
        transaccion = new Transaccion();
        socio= new Socio();
        transaccion.setSocio(socio);
        return "crearTransaccion.xhtml";
    }
    
    //Crea el evento con los datos proporcionado en la vista de creación
    public String createTransaccion(){
        transaccion.setId_Transaccion(transacEJB.getNextId());
        transacEJB.crear(transaccion);
        return "listarTransacciones.xhtml";
    }
    
    public String modTransaccion(Transaccion transac){
        transaccion = transac;
        return "modificarTransaccion.xhtml";
    }
    
    public String updateTransaccion(){
        transacEJB.modificar(transaccion);
        return "listarTransacciones.xhtml";
    }
    
    public String readTransaccion(Transaccion transaccion){
        this.transaccion = transaccion;
        return "consultarTransaccion.xhtml";
    }
    
    public String deleteTransaccion(Transaccion transaccion){
        transacEJB.remove(transaccion);
        return "listarTransacciones.xhtml";
    }
}
