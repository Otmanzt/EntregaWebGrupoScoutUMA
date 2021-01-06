/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.ejb;

import com.softbox.entity.Pago_Cuota;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author miguel_martin
 */
@Local
public interface Pago_CuotaFacadeLocal {

    void create(Pago_Cuota pago_Cuota);

    void edit(Pago_Cuota pago_Cuota);

    void remove(Pago_Cuota pago_Cuota);

    Pago_Cuota find(Object id);

    List<Pago_Cuota> findAll();

    List<Pago_Cuota> findRange(int[] range);

    int count();
    
    void modificar(Pago_Cuota pago_Cuota);
    
    Long getNextId();
    
    void crear(Pago_Cuota pago_Cuota);
    
}
