/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.ejb;

import com.softbox.entity.Documento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author miguel_martin
 */
@Local
public interface DocumentoFacadeLocal {

    void create(Documento documento);

    void edit(Documento documento);

    void remove(Documento documento);

    Documento find(Object id);

    List<Documento> findAll();

    List<Documento> findRange(int[] range);

    int count();
    
    Long getNextId();
    
    List<Documento> getByIdUser(Long id_user);
}
