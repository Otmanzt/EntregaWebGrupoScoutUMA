/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.ejb;

import com.softbox.entity.Socio;
import com.softbox.exception.ScoutException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author miguel_martin
 */
@Local
public interface SocioFacadeLocal {

    void create(Socio socio);

    void edit(Socio socio);

    void remove(Socio socio);
    
    Socio comprobarLogin(Socio socio) throws ScoutException;

    Socio find(Object id);

    List<Socio> findAll();

    List<Socio> findRange(int[] range);

    int count();

    Long getNextId();
    Socio getByIdUser (Long id_user);
    
}
