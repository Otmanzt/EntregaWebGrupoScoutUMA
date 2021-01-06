/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.ejb;

import com.softbox.entity.Notificacion_Documento;
import com.softbox.entity.Notificacion_Evento;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author miguel_martin
 */
@Stateless
public class Notificacion_EventoFacade extends AbstractFacade<Notificacion_Evento> implements Notificacion_EventoFacadeLocal {

    @PersistenceContext(unitName = "GrupoSA_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Notificacion_EventoFacade() {
        super(Notificacion_Evento.class);
    }
    
    @Override
    public List<Notificacion_Evento> findByIdEvento (Long id_evento){
       TypedQuery<Notificacion_Evento> query = em.createQuery("Select N from Notificacion_Evento N where N.evento.id_evento :fid_evento", Notificacion_Evento.class);
       query.setParameter("fid_evento", id_evento);
       return query.getResultList();
    }
    
    @Override
    public Notificacion_Evento getNotById (Long id_not){
        TypedQuery<Notificacion_Evento> query = em.createQuery("Select N from Notificacion_Evento N where N.id_not_evento = :fid_not", Notificacion_Evento.class);
        query.setParameter("fid_not", id_not);
        Notificacion_Evento notificacion = query.getResultList().get(0);
        return notificacion;
    }
    
    @Override
    public List<Notificacion_Evento> findByIdUser (Long id_user){
        TypedQuery<Notificacion_Evento> query = em.createQuery("Select N from Notificacion_Evento N where N.socio.id_Usuario  = :fid_user", Notificacion_Evento.class);
        query.setParameter("fid_user", id_user);
        return query.getResultList();
    }
    
    
    
    @Override
    public Long getNextId() {
        TypedQuery<BigDecimal> q = (TypedQuery<BigDecimal>) em.createNativeQuery("SELECT seq_count FROM SEQUENCE where seq_name = 'S_NOTEVENTO'");
        Query q2 = em.createNativeQuery("UPDATE SEQUENCE SET SEQ_COUNT = SEQ_COUNT + 1 WHERE SEQ_NAME = 'S_NOTEVENTO'");
        q2.executeUpdate();
        return q.getSingleResult().longValue();
    }
}
