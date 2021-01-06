/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.backingBeans;

import com.softbox.ejb.DocumentoFacadeLocal;
import com.softbox.ejb.Notificacion_DocumentoFacadeLocal;
import com.softbox.ejb.SocioFacadeLocal;
import com.softbox.entity.Documento;
import com.softbox.entity.EstadoDoc;
import com.softbox.entity.Notificacion_Documento;
import com.softbox.entity.Socio;
import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author migue
 */
@Named(value = "misDocs")
@SessionScoped
public class misDocs implements Serializable{
   private Documento doc;
   private Long id_usuario;
   private List<Socio> socios;
   private List<Documento> listaDocs;
   
    /* Interfaz de EJB */
    @Inject
    private DocumentoFacadeLocal docEJB;
    
    @Inject
    private Notificacion_DocumentoFacadeLocal notEJB;
    
    @Inject
    private SocioFacadeLocal socioEJB;

    public List<Socio> getSocios() {
        return socioEJB.findAll();
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    /**
     * Creates a new instance of misDocs
     */
    public misDocs() {
    }

    public Documento getDoc() {
        return doc;
    }

    public void setDoc(Documento doc) {
        this.doc = doc;
    }
    
    public String crearDocumento(){
        doc = new Documento(); 
        socios = socioEJB.findAll();
        return "crearDocumento.xhtml";
    }
    
    public String insertarDoc(){
        doc.setId_documento(docEJB.getNextId());
        doc.setEstado(EstadoDoc.PENDIENTE);
        doc.setEnlace("");
        doc.setFecha(Date.valueOf(LocalDate.now()));
        Socio s = socioEJB.getByIdUser(id_usuario);
        doc.setSocio(s);
        docEJB.create(doc);
        Notificacion_Documento notif = new Notificacion_Documento();
        
        notif.setSocio(s);
        notif.setFechaNotificacion(Date.valueOf(LocalDate.now()));
        notif.setEstado("False");
        notif.setDocumento(doc);
        notEJB.create(notif);
        
        return "documentosLista.xhtml";
    }
    
    public void subirFichero(Documento doc){
        docEJB.create(doc);
        docEJB.edit(doc);
    }
    
    public String getEnlace(Documento doc){
        return doc.getEnlace();
    }
    
    
    public void validarDoc (Documento doc){
        doc.setEstado(EstadoDoc.ACEPTADO);
        docEJB.edit(doc);
    }
    
    public void rechazarDoc (Documento doc){
        doc.setEstado(EstadoDoc.DENEGADO);
        docEJB.edit(doc);
    }
    

    public List<Documento> getLista_docs() {
        return docEJB.findAll();
    }


    public Documento getMiDoc(Documento doc) {
        return docEJB.find(doc);
    }

    
    public String borrarDocAdmin(Documento doc){
        //return "index.xhtml";
        
        for (Notificacion_Documento not : notEJB.findByIdDoc(doc.getId_documento())){
            notEJB.remove(not);
        }
        docEJB.remove(doc);
        return "documentosLista.xhtml";
    }
    
    public String borrarMisDoc(Documento doc){
        //return "index.xhtml";
        
        for (Notificacion_Documento not : notEJB.findByIdDoc(doc.getId_documento())){
            notEJB.remove(not);
        }
        docEJB.remove(doc);
        return "misDocumentos.xhtml";
    }
    
     public List<Documento> getMisDocs(Long id_us){
        return docEJB.getByIdUser(id_us);
    }
}
