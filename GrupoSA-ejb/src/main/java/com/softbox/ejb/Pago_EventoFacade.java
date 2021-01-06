/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.ejb;

import com.softbox.entity.Evento;
import com.softbox.entity.Pago_Evento;
import com.softbox.entity.Socio;
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
public class Pago_EventoFacade extends AbstractFacade<Pago_Evento> implements Pago_EventoFacadeLocal {

    @PersistenceContext(unitName = "GrupoSA_PU")
    private EntityManager em;
    
    @Inject
    private SocioFacadeLocal socioEJB;
    
    @Inject
    private EventoFacadeLocal eventoEJB;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Pago_EventoFacade() {
        super(Pago_Evento.class);
    }
    
    @Override
    public void modificar(Pago_Evento pago_Evento){
        Long id_usuario=pago_Evento.getSocio().getId_Usuario();
        Long id_evento=pago_Evento.getEvento().getId_evento();
        
        Socio usuario =socioEJB.find(id_usuario);
        Evento evento=eventoEJB.find(id_evento);

        if(usuario!=null){
            pago_Evento.setSocio(usuario);
        }
         
        if(evento!=null){
            pago_Evento.setEvento(evento);
        }
        edit(pago_Evento);
    }
    
    @Override
    public Long getNextId() {
        TypedQuery<BigDecimal> q = (TypedQuery<BigDecimal>) em.createNativeQuery("SELECT seq_count FROM SEQUENCE where seq_name = 'S_IDPAGOEVENTO'");
        Query q2 = em.createNativeQuery("UPDATE SEQUENCE SET SEQ_COUNT = SEQ_COUNT + 1 WHERE SEQ_NAME = 'S_IDPAGOEVENTO'");
        q2.executeUpdate();
        return q.getSingleResult().longValue();
    }
    
    @Override
    public void crear(Pago_Evento pago_Evento){
        Long id_usuario=pago_Evento.getSocio().getId_Usuario();
        Long id_evento=pago_Evento.getEvento().getId_evento();
        
        Socio usuario =socioEJB.find(id_usuario);
        Evento evento=eventoEJB.find(id_evento);

        if(usuario!=null){
            pago_Evento.setSocio(usuario);
        }
         
        if(evento!=null){
            pago_Evento.setEvento(evento);
        }
        create(pago_Evento);
    }
    
}
