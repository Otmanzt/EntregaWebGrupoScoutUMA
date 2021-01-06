/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.ejb;

import com.softbox.entity.Evento;
import com.softbox.entity.Seccion;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
/**
 *
 * @author miguel_martin
 */
@Stateless
public class EventoFacade extends AbstractFacade<Evento> implements EventoFacadeLocal {

    @PersistenceContext(unitName = "GrupoSA_PU")
    private EntityManager em;

    @Inject
    private SeccionFacadeLocal seccionEJB;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EventoFacade() {
        super(Evento.class);
    }
    
    @Override
    public void modificar(Evento evento){
        Long id_seccion=evento.getSeccion().getId_seccion();
        
        Seccion seccion =seccionEJB.find(id_seccion);
        if(seccion!=null){
            evento.setSeccion(seccion);
        }
        
        edit(evento);
    }
    
    @Override
    public Long getNextId() {
        TypedQuery<BigDecimal> q = (TypedQuery<BigDecimal>) em.createNativeQuery("SELECT seq_count FROM SEQUENCE where seq_name = 'S_IDEVENTO'");
        Query q2 = em.createNativeQuery("UPDATE SEQUENCE SET SEQ_COUNT = SEQ_COUNT + 1 WHERE SEQ_NAME = 'S_IDEVENTO'");
        q2.executeUpdate();
        return q.getSingleResult().longValue();
    }
    
    @Override
    public void crear(Evento evento){
        Long id_seccion=evento.getSeccion().getId_seccion();
        
        Seccion seccion =seccionEJB.find(id_seccion);

        if(seccion!=null){
            evento.setSeccion(seccion);
        }
        
        create(evento);
    }
    
    @Override
    public void borrar(Evento evento){
        
        Query q = em.createNativeQuery("DELETE FROM ASISTENCIA WHERE ASISTENCIA_EVENTO_FK ="+evento.getId_evento());
        q.executeUpdate();
        
        Query q2= em.createNativeQuery("DELETE FROM INSCRIPCION WHERE INSCRIPCION_EVENTO_FK ="+evento.getId_evento());
        q2.executeUpdate();
        remove(evento);
    }
    @Override
    public List<Evento> findBySeccion(Long id_Seccion){
        TypedQuery tq = em.createQuery("SELECT e FROM Evento e WHERE e.seccion.id_seccion = :fseccion", Evento.class).setParameter("fseccion", id_Seccion);
        List<Evento> lista = tq.getResultList();
        return lista;
    }  
    
    @Override
    public boolean usuarioInscrito(Long id_Socio, Long id_Evento){
        Query q = em.createNativeQuery("SELECT * FROM Inscripcion i where i.inscripcion_socio_fk="+id_Socio+" AND i.inscripcion_evento_fk ="+id_Evento+"");
        List<Object> lista = q.getResultList();
        
        boolean encontrado=false;
        
        if(lista != null){
            encontrado = lista.size()==1;
        }
        return encontrado;
    }
    
    @Override
    public void inscribirSocio(Long id_Socio, Long id_Evento){
         em.createNativeQuery("INSERT INTO INSCRIPCION VALUES("+id_Socio+","+id_Evento+")").executeUpdate();
    }
}
    
    
