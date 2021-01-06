/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.backingBeans;

import com.softbox.ejb.Pago_CuotaFacadeLocal;
import com.softbox.ejb.Pago_EventoFacadeLocal;
import com.softbox.entity.Cuota;
import com.softbox.entity.Evento;
import com.softbox.entity.Pago_Cuota;
import com.softbox.entity.Pago_Evento;
import com.softbox.entity.Socio;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Borja Delgado
 */
@Named(value = "pagosBB")
@SessionScoped
public class pagosBB implements Serializable{
    
    private Pago_Cuota pago_cuota = new Pago_Cuota();
    private Pago_Evento pago_evento= new Pago_Evento();
    private boolean modo;
    
    @Inject
    private Pago_EventoFacadeLocal pago_EventoEJB;
    
    @Inject
    private Pago_CuotaFacadeLocal pago_CuotaEJB;
    /**
     * Creates a new instance of sociosBB
     */
    public pagosBB() {
    }

    public List<Pago_Evento> getPagosEventos() {
        return pago_EventoEJB.findAll();
    }


    public Pago_Evento getPago_evento() {
        return pago_evento;
    }

    public void setPago_evento(Pago_Evento pago_evento) {
        this.pago_evento = pago_evento;
    }

    
    public List<Pago_Cuota> getPagosCuotas() {
       return pago_CuotaEJB.findAll(); 
    
    }

    public Pago_Cuota getPago_Cuota() {
        return pago_cuota;
    }

    public void setPago_Cuota(Pago_Cuota pago_cuota) {
        this.pago_cuota = pago_cuota;
    }
    
    //Accede a la vista de creación de pagosEventos
    public String newPagoCuota(){
        modo=true;
        Socio socio=new Socio();
        Cuota cuota=new Cuota();
        pago_cuota = new Pago_Cuota();
        pago_cuota.setSocio(socio);
        pago_cuota.setCuota(cuota);
        return "crearPago.xhtml";
    }
    
    public String newPagoEvento(){
        modo=false;
        Socio socio=new Socio();
        Evento evento=new Evento();
        pago_evento=new Pago_Evento();
        pago_evento.setSocio(socio);
        pago_evento.setEvento(evento);
        return "crearPago.xhtml";
    }
    
    //Crea el pago_evento con los datos proporcionado en la vista de creación
    public String createPagoCuota(){
        pago_cuota.setId_Pago(pago_CuotaEJB.getNextId());        
        pago_CuotaEJB.crear(pago_cuota);
        return "listarPagos.xhtml";
    }
    
    public String createPagoEvento(){
        pago_evento.setId_Pago(pago_EventoEJB.getNextId());
        pago_EventoEJB.crear(pago_evento);
        return "listarPagos.xhtml";
    }
    public String modPagoEvento(Pago_Evento pago_evento){
        this.pago_evento = pago_evento;
        return "modificarPago.xhtml";
    }
    
    public String modPagoCuota(Pago_Cuota pago_cuota){
        this.pago_cuota= pago_cuota;
        return "modificarPago.xhtml";
    }
    public String updatePago(){
        if(modo){
            pago_CuotaEJB.modificar(pago_cuota);
        }else{
           pago_EventoEJB.modificar(pago_evento);
        }
        
        return  "listarPagos.xhtml";
    }
    
    public String readPagoCuota(Pago_Cuota pago_cuota){
        this.pago_cuota = pago_cuota;
        return "consultarPago.xhtml";
    }
    public String readPagoEvento(Pago_Evento pago_evento){
        this.pago_evento = pago_evento;
        return "consultarPago.xhtml";
    }
    
    public String deletePagoCuota(Pago_Cuota soc){
        pago_CuotaEJB.remove(soc);
        return "listarPagos.xhtml";
    }
    public String deletePagoEvento(Pago_Evento soc){
        pago_EventoEJB.remove(soc);
        return "listarPagos.xhtml";
    }
    
    public void cambiarModo(){
        modo=!modo;
    }
    public boolean getModo(){
        return modo;
    }
    public void setModo(boolean modo){
        this.modo=modo;
    }
}
