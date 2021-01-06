/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.ejb;

import com.softbox.entity.Seccion;
import java.math.BigDecimal;
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
public class SeccionFacade extends AbstractFacade<Seccion> implements SeccionFacadeLocal {

    @PersistenceContext(unitName = "GrupoSA_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeccionFacade() {
        super(Seccion.class);
    }
    
    @Override
    public Seccion findByNombre(String nombre){
        TypedQuery<Seccion> q = em.createQuery("SELECT S FROM Seccion S WHERE S.nombre = :fnombre", Seccion.class);
        q.setParameter("fnombre", nombre);
        Seccion s = null;
        
        if(q.getResultList().size() >0){
            s = q.getResultList().get(0);
        }
        return s;
    }

    @Override
    public Long getNextId() {
        TypedQuery<BigDecimal> q = (TypedQuery<BigDecimal>) em.createNativeQuery("SELECT seq_count FROM SEQUENCE where seq_name = 'S_IDSECCION'");
        Query q2 = em.createNativeQuery("UPDATE SEQUENCE SET SEQ_COUNT = SEQ_COUNT + 1 WHERE SEQ_NAME = 'S_IDSECCION'");
        q2.executeUpdate();
        return q.getSingleResult().longValue();
    }

}
