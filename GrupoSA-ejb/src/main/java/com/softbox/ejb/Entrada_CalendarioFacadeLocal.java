/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.ejb;

import com.softbox.entity.Entrada_Calendario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author miguel_martin
 */
@Local
public interface Entrada_CalendarioFacadeLocal {

    void create(Entrada_Calendario entrada_Calendario);

    void edit(Entrada_Calendario entrada_Calendario);

    void remove(Entrada_Calendario entrada_Calendario);

    Entrada_Calendario find(Object id);

    List<Entrada_Calendario> findAll();

    List<Entrada_Calendario> findByIdSocio(Long idSocio);

    List<Entrada_Calendario> findRange(int[] range);

    int count();
    
        Long getNextId();

    
}
