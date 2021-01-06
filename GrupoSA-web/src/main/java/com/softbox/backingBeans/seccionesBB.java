/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.backingBeans;

import com.softbox.ejb.EventoFacadeLocal;
import com.softbox.ejb.SeccionFacadeLocal;
import com.softbox.entity.Evento;
import com.softbox.entity.Seccion;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author migue
 */
@Named(value = "seccionesBB")
@SessionScoped
public class seccionesBB implements Serializable{
    @Inject
    private SeccionFacadeLocal secEjb;
    @Inject
    private EventoFacadeLocal eventoEjb;
    private Seccion seccion;
    private List<Evento> lista;
    /**
     * Creates a new instance of seccionesBB
     */
    public seccionesBB() {
    }

    public List<Evento> getLista() {
        return lista;
    }

    public void setLista(List<Evento> lista) {
        this.lista = lista;
    }
    
    public String cargarLista(Long id_Seccion){
        this.seccion = secEjb.find(id_Seccion);
        this.lista = eventoEjb.findBySeccion(id_Seccion);
        return "eventos.xhtml";
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    
    
    
}
