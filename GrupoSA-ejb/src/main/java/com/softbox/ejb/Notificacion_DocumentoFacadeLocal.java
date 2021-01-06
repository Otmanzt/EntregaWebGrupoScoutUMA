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
public interface Notificacion_DocumentoFacadeLocal {

    void create(Notificacion_Documento notificacion_Documento);

    void edit(Notificacion_Documento notificacion_Documento);

    void remove(Notificacion_Documento notificacion_Documento);

    Notificacion_Documento find(Object id);

    List<Notificacion_Documento> findAll();

    List<Notificacion_Documento> findRange(int[] range);

    int count();
    
    List<Notificacion_Documento> findByIdDoc (Long id_doc);
    
    Notificacion_Documento getNotById (Long id_not);
    
    List<Notificacion_Documento> findByIdUser (Long id_user);
    
}
