/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.backingBeans;

import com.softbox.ejb.Entrada_CalendarioFacadeLocal;
import com.softbox.entity.Entrada_Calendario;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Borja Delgado
 */
@Named(value = "CalendarioBB")
@SessionScoped
public class CalendarioBB implements Serializable{
    
    private Entrada_Calendario entCal = new Entrada_Calendario();
    private Long buscador = Long.parseLong("0");

    @Inject
    private Entrada_CalendarioFacadeLocal ecf;
    
    /**
     * Creates a new instance of sociosBB
     */
    public CalendarioBB() {
    }

    public Entrada_Calendario getEntCal() {
        return entCal;
    }

    public void setEntCal(Entrada_Calendario entCal) {
        this.entCal = entCal;
    }

    public Long getBuscador() {
        return buscador;
    }

    public void setBuscador(Long buscador) {
        this.buscador = buscador;
    }
    
    public List<Entrada_Calendario> getCalendario() {
        if(buscador==null) return ecf.findAll();
        else if(buscador==0L) return ecf.findAll();
        return ecf.findByIdSocio(buscador);
    }

    public String readEntradaCalendario(Entrada_Calendario ent1){
        entCal = ent1;
        return "consultarEntradaCalendario.xhtml";
    }
    
    public String limpiarBusqueda(){
        buscador = Long.parseLong("0");
        return "listarCalendario.xhtml";
    }
}
