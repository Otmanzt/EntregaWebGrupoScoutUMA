/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.backingBeans;

import com.softbox.ejb.ComentarioFacadeLocal;
import com.softbox.ejb.EventoFacadeLocal;
import com.softbox.entity.Comentario;
import com.softbox.entity.Evento;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import javax.inject.Inject;

/**
 *
 * @author migue
 */
@Named(value = "eventoEduBB")
@SessionScoped
public class eventoEduBB implements Serializable{
    @Inject
    private EventoFacadeLocal eventoEjb;
    @Inject
    private ComentarioFacadeLocal comenEjb;
    
    private Evento evt;
    private List<Comentario> listComen;
    
    /**
     * Creates a new instance of eventoEduBB
     */
    public eventoEduBB() {
    }

    public Evento getEvt() {
        return evt;
    }

    public void setEvt(Evento evt) {
        this.evt = evt;
    }
    public String mostrarEvento(Long id){
        evt = eventoEjb.find(id);
        listComen = comenEjb.findByEvento(id);
        return "evento.xhtml";
    }

    public List<Comentario> getListComen() {
        return listComen;
    }

    public void setListComen(List<Comentario> listComen) {
        this.listComen = listComen;
    }
    
    public String inscribirseEvento(Long id_Socio){
        eventoEjb.inscribirSocio(id_Socio, evt.getId_evento());
        return mostrarEvento(evt.getId_evento());
    }
    
    public boolean socioInscrito(Long id_socio){
        return eventoEjb.usuarioInscrito(id_socio, evt.getId_evento());
    }
}
