/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.ejb;

import com.softbox.entity.Comentario;
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
public class ComentarioFacade extends AbstractFacade<Comentario> implements ComentarioFacadeLocal {

    @PersistenceContext(unitName = "GrupoSA_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComentarioFacade() {
        super(Comentario.class);
    }
    
    @Override
    public List<Comentario> findByEvento(Long id_Evento){
        TypedQuery tq = em.createQuery("SELECT c FROM Comentario c WHERE c.evento.id_evento = :fevento", Comentario.class).setParameter("fevento", id_Evento);
        List<Comentario> lista = tq.getResultList();
        return lista;
    }
}
