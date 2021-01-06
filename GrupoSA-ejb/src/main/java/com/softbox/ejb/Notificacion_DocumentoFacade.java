/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.ejb;

import com.softbox.entity.Notificacion_Documento;
import com.softbox.entity.Notificacion_Evento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author miguel_martin
 */
@Stateless
public class Notificacion_DocumentoFacade extends AbstractFacade<Notificacion_Documento> implements Notificacion_DocumentoFacadeLocal {

    @PersistenceContext(unitName = "GrupoSA_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Notificacion_DocumentoFacade() {
        super(Notificacion_Documento.class);
    }
    
    @Override
    public List<Notificacion_Documento> findByIdDoc (Long id_doc){
       TypedQuery<Notificacion_Documento> query = em.createQuery("Select N from Notificacion_Documento N where N.documento.id_documento = :fid_doc", Notificacion_Documento.class);
       query.setParameter("fid_doc", id_doc);
       return query.getResultList();
    }
    
    @Override
    public Notificacion_Documento getNotById (Long id_not){
        TypedQuery<Notificacion_Documento> query = em.createQuery("Select N from Notificacion_Documento N where N.id_not_documento = :fid_not", Notificacion_Documento.class);
        query.setParameter("fid_not", id_not);
        Notificacion_Documento notificacion = query.getResultList().get(0);
        return notificacion;
    }
    
    @Override
    public List<Notificacion_Documento> findByIdUser (Long id_user){
        TypedQuery<Notificacion_Documento> query = em.createQuery("Select N from Notificacion_Documento N where N.socio.id_Usuario  = :fid_user", Notificacion_Documento.class);
        query.setParameter("fid_user", id_user);
        return query.getResultList();
    }
    
}
