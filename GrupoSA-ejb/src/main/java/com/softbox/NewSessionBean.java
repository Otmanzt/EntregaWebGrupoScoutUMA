/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author martin
 */
@Stateless
@LocalBean
public class NewSessionBean {
    @PersistenceContext(unitName = "GrupoSA_PU")
    private EntityManager em;
    public void businessMethod() {
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
