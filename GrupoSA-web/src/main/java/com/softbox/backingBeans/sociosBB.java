/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.backingBeans;

import com.softbox.ejb.SeccionFacadeLocal;
import com.softbox.ejb.SocioFacadeLocal;
import com.softbox.ejb.UsuarioFacadeLocal;
import com.softbox.entity.Socio;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Borja Delgado
 */
@Named(value = "sociosBB")
@SessionScoped
public class sociosBB implements Serializable{
    
    @Inject
    private SocioFacadeLocal sf;
    @Inject
    private UsuarioFacadeLocal uf;
    @Inject
    private SeccionFacadeLocal secf;
    
    private Socio socio = new Socio();

    /**
     * Creates a new instance of sociosBB
     */
    public sociosBB() {
    }

    public List<Socio> getSociosEJB() {
        return sf.findAll();
    }
    
    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    //Accede a la vista de creación de socios
    public String newSocio(){
        socio = new Socio();
        return "crearSocio.xhtml";
    }
    
    //Crea el socio con los datos proporcionado en la vista de creación
    public String createSocio(){
        socio.setId_Socio(sf.getNextId());
        socio.setId_Usuario(uf.getNextId());
        socio.setPass("1234");
        socio.setFecha_ingreso(Date.valueOf(LocalDate.now()));
        socio.setSeccion(secf.findByNombre(socio.getGrupo()));
        sf.create(socio);
        return "sociosLista.xhtml";
    }
    
    
    public String modSocio(Socio soc){
        socio = soc;
        return "modificarSocio.xhtml";
    }
    
    public String updateSocio(){
        socio.setSeccion(secf.findByNombre(socio.getGrupo()));
        sf.edit(socio);
        return "sociosLista.xhtml";
    }
    
    public String readSocio(Socio soc){
        socio = soc;
        return "consultarSocio.xhtml";
    }
    
    public String deleteSocio(Socio soc){
        soc.setFecha_baja(Date.valueOf(LocalDate.now()));
        sf.edit(soc);
        return "sociosLista.xhtml";
    }
    
    public Socio getSocioByID(Long id){
        return sf.find(id);
    }
}
