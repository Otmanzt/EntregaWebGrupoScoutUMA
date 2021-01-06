/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.ejb;

import com.softbox.entity.Cuota;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author miguel_martin
 */
@Local
public interface CuotaFacadeLocal {

    void create(Cuota cuota);

    void edit(Cuota cuota);

    void remove(Cuota cuota);

    Cuota find(Object id);

    List<Cuota> findAll();

    List<Cuota> findRange(int[] range);

    int count();
    
    Long getNextId();
    
}
