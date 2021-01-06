/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.ejb;

import com.softbox.entity.Socio;
import com.softbox.entity.Transaccion;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author miguel_martin
 */
@Stateless
public class TransaccionFacade extends AbstractFacade<Transaccion> implements TransaccionFacadeLocal {

    @PersistenceContext(unitName = "GrupoSA_PU")
    private EntityManager em;
    
    @Inject
    private SocioFacadeLocal socioEJB;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransaccionFacade() {
        super(Transaccion.class);
    }
    
    @Override
     public void modificar (Transaccion transaccion){
         Long id_Usuario = transaccion.getSocio().getId_Usuario();
     
         Socio usuario = socioEJB.find(id_Usuario);
         
         if(usuario!=null){
            transaccion.setSocio(usuario);
         }
         edit(transaccion);
     }
     
    @Override
     public Long getNextId() {
        TypedQuery<BigDecimal> q = (TypedQuery<BigDecimal>) em.createNativeQuery("SELECT seq_count FROM SEQUENCE where seq_name = 'S_TRANSACCION'");
        Query q2 = em.createNativeQuery("UPDATE SEQUENCE SET SEQ_COUNT = SEQ_COUNT + 1 WHERE SEQ_NAME = 'S_TRANSACCION'");
        q2.executeUpdate();
        return q.getSingleResult().longValue();
    }
     
     @Override
     public void crear(Transaccion transaccion){
         Long id_Usuario = transaccion.getSocio().getId_Usuario();
     
         Socio usuario = socioEJB.find(id_Usuario);
         
         if(usuario!=null){
            transaccion.setSocio(usuario);
         }
         create(transaccion);
     }
}
