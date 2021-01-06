/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.ejb;

import com.softbox.entity.Pago_Evento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author miguel_martin
 */
@Local
public interface Pago_EventoFacadeLocal {

    void create(Pago_Evento pago_Evento);

    void edit(Pago_Evento pago_Evento);

    void remove(Pago_Evento pago_Evento);

    Pago_Evento find(Object id);

    List<Pago_Evento> findAll();

    List<Pago_Evento> findRange(int[] range);

    int count();
    
    void modificar(Pago_Evento pago_Evento);
    
    Long getNextId();
    
    void crear(Pago_Evento pago_Evento);
}
