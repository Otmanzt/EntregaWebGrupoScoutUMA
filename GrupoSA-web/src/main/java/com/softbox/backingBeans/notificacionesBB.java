/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.backingBeans;

import com.softbox.ejb.Notificacion_DocumentoFacadeLocal;
import com.softbox.ejb.Notificacion_EventoFacadeLocal;
import com.softbox.entity.Documento;
import com.softbox.entity.Evento;
import com.softbox.entity.Notificacion_Documento;
import com.softbox.entity.Notificacion_Evento;
import com.softbox.entity.Socio;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author migue
 */
@Named(value = "notificacionesBB")
@SessionScoped
public class notificacionesBB implements Serializable{
    
    /* EJB */
    @Inject
    private Notificacion_DocumentoFacadeLocal not_docEJB;
    
    @Inject
    private Notificacion_EventoFacadeLocal not_EventoEJB;
    
   
    /**
     * Creates a new instance of notificacionesBB
     */
    private int noLeidas;
    private List<Notificacion_Evento> notifs_evento;
    private List<Notificacion_Documento> notifs_doc;

    
    public notificacionesBB() {

    }

    public List<Notificacion_Evento> getNotifs_evento() {
        return notifs_evento;
    }

    public void setNotifs_evento(List<Notificacion_Evento> notifs_evento) {
        this.notifs_evento = notifs_evento;
    }

    public List<Notificacion_Documento> getNotifs_doc() {
        return notifs_doc;
    }

    public void setNotifs_doc(List<Notificacion_Documento> notifs_doc) {
        this.notifs_doc = notifs_doc;
    }

    

    public String marcarLeidoEvento (Notificacion_Evento notif){
        this.noLeidas--;
        notif.setEstado("True");
        not_EventoEJB.edit(notif);
        return "misNotificaciones.xhtml";
    }
    
    public String marcarLeidoDoc (Notificacion_Documento notif){
        this.noLeidas--;
        notif.setEstado("True");
        not_docEJB.edit(notif);
        return "misNotificaciones.xhtml";
    }
    public String borrarNotiEvento(Notificacion_Evento notif){
        if (notif.getEstado().equalsIgnoreCase("False")){
            this.noLeidas--;
        }
        not_EventoEJB.remove(notif); 
        return "misNotificaciones.xhtml";
    }
    
    public String borrarNotiDoc(Notificacion_Documento notif){
        if (notif.getEstado().equalsIgnoreCase("False")){
            this.noLeidas--;
        }
        not_docEJB.remove(notif); 
        return "misNotificaciones.xhtml";
    }
    public int getNoLeidas() {
        return noLeidas;
    }

    public void setNoLeidas(int noLeidas) {
        this.noLeidas = noLeidas;
    }
    
    public String irNotif(Long id_usuario){
        notifs_evento = not_EventoEJB.findByIdUser(id_usuario);
        notifs_doc = not_docEJB.findByIdUser(id_usuario);
        
        return "misNotificaciones.xhtml";
    }

    public void calcularNoLeidas(Long id_usuario){
        int noLeidas = 0;
        
        List<Notificacion_Documento> listaDoc = notifs_doc = not_docEJB.findByIdUser(id_usuario);
        List<Notificacion_Evento> listaEvt = notifs_evento = not_EventoEJB.findByIdUser(id_usuario);
        
        for(Notificacion_Documento a : listaDoc){
            if(a.getEstado().equals("False")){
                noLeidas++;
            }
        }

        for(Notificacion_Evento a : listaEvt){
            if(a.getEstado().equals("False")){
                noLeidas++;
            }
        }
        setNoLeidas(noLeidas);
    }
    public Notificacion_Evento getNotificacion_Evento(Long id){
        return not_EventoEJB.getNotById(id);
    }
    
    
    public Notificacion_Documento getNotificacion_Doc(Long id){
        return not_docEJB.getNotById(id);
    }
    
    
    public void crearNotifEvento(Socio soc, Evento eve){
        Notificacion_Evento notificacion = new Notificacion_Evento();
        notificacion.setId_not_evento(not_EventoEJB.getNextId());
        notificacion.setSocio(soc);
        notificacion.setEvento(eve);
        notificacion.setEstado("False");
        notificacion.setFechaNotificacion(Date.valueOf(LocalDate.now()));
        not_EventoEJB.create(notificacion);
    }
    
    //Accede a la vista de creación de socios
    
    
    //Crea el socio con los datos proporcionado en la vista de creación

}
