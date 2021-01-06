/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.ejb;

import com.softbox.entity.Notificacion_Documento;
import com.softbox.entity.Notificacion_Evento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author miguel_martin
 */
@Local
public interface Notificacion_EventoFacadeLocal {

    void create(Notificacion_Evento notificacion_Evento);

    void edit(Notificacion_Evento notificacion_Evento);

    void remove(Notificacion_Evento notificacion_Evento);

    Notificacion_Evento find(Object id);

    List<Notificacion_Evento> findAll();

    List<Notificacion_Evento> findRange(int[] range);

    int count();
    
    List<Notificacion_Evento> findByIdEvento (Long id_evento);
    
    Notificacion_Evento getNotById (Long id_not);
    
    List<Notificacion_Evento> findByIdUser (Long id_user);
    
    Long getNextId();
    
}
