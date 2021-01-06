/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.ejb;

//import com.softbox.entity.Cuota;
import com.softbox.entity.Cuota;
import com.softbox.entity.Pago_Cuota;
import com.softbox.entity.Socio;
import java.math.BigDecimal;
//import com.softbox.entity.Socio;
//import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
//import javax.persistence.Query;

/**
 *
 * @author miguel_martin
 */
@Stateless
public class Pago_CuotaFacade extends AbstractFacade<Pago_Cuota> implements Pago_CuotaFacadeLocal {

    @PersistenceContext(unitName = "GrupoSA_PU")
    private EntityManager em;
    
    @Inject
    private SocioFacadeLocal socioEJB;
    
    @Inject
    private CuotaFacadeLocal cuotaEJB;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Pago_CuotaFacade() {
        super(Pago_Cuota.class);
    }
    
    @Override
    public void modificar(Pago_Cuota pago_Cuota){
        Long id_usuario=pago_Cuota.getSocio().getId_Usuario();
        Long id_cuota=pago_Cuota.getCuota().getId_Cuota();
        

        
        Socio usuario =socioEJB.find(id_usuario);
        Cuota cuota=cuotaEJB.find(id_cuota);

        if(usuario!=null){
            pago_Cuota.setSocio(usuario);
        }
         
        if(cuota!=null){
            pago_Cuota.setCuota(cuota);
        }
        edit(pago_Cuota);
    }
    
        @Override
    public Long getNextId() {
        TypedQuery<BigDecimal> q = (TypedQuery<BigDecimal>) em.createNativeQuery("SELECT seq_count FROM SEQUENCE where seq_name = 'S_IDPAGOCUOTA'");
        Query q2 = em.createNativeQuery("UPDATE SEQUENCE SET SEQ_COUNT = SEQ_COUNT + 1 WHERE SEQ_NAME = 'S_IDPAGOCUOTA'");
        q2.executeUpdate();
        return q.getSingleResult().longValue();
    }
    @Override
    public void crear(Pago_Cuota pago_Cuota){
        Long id_usuario=pago_Cuota.getSocio().getId_Usuario();
        Long id_cuota=pago_Cuota.getCuota().getId_Cuota();

        
        Socio usuario =socioEJB.find(id_usuario);
        Cuota cuota=cuotaEJB.find(id_cuota);

        if(usuario!=null){
            pago_Cuota.setSocio(usuario);
        }
         
        if(cuota!=null){
            pago_Cuota.setCuota(cuota);
        }
        create(pago_Cuota);
    }
    
}
