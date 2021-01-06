/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.ejb;

import com.softbox.entity.Documento;
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
public class DocumentoFacade extends AbstractFacade<Documento> implements DocumentoFacadeLocal {

    @PersistenceContext(unitName = "GrupoSA_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocumentoFacade() {
        super(Documento.class);
    }
    
    @Override
    public Long getNextId() {
        TypedQuery<BigDecimal> q = (TypedQuery<BigDecimal>) em.createNativeQuery("SELECT seq_count FROM SEQUENCE where seq_name = 'S_DOCUMENTO'");
        Query q2 = em.createNativeQuery("UPDATE SEQUENCE SET SEQ_COUNT = SEQ_COUNT + 1 WHERE SEQ_NAME = 'S_DOCUMENTO'");
        q2.executeUpdate();
        return q.getSingleResult().longValue();
    }
    
    @Override
    public List<Documento> getByIdUser(Long id_user){
        TypedQuery<Documento> query = em.createQuery("Select d from Documento d where d.socio.id_Usuario = :fid_user", Documento.class);
        query.setParameter("fid_user", id_user);
        return query.getResultList();
    }
    
}
