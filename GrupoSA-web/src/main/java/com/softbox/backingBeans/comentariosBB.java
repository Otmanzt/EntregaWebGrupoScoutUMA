/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.backingBeans;

import com.softbox.ejb.ComentarioFacadeLocal;
import com.softbox.entity.Comentario;
import com.softbox.entity.Evento;
import com.softbox.entity.Socio;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.inject.Inject;

/**
 *
 * @author migue
 */
@Named(value = "comentariosBB")
@SessionScoped
public class comentariosBB implements Serializable {
    @Inject
    private ComentarioFacadeLocal comenEjb;
    @Inject
    private eventoEduBB edu;
    private String textoComentario;
    /**
     * Creates a new instance of comentariosBB
     */
    public comentariosBB() {
    }

    public String getTextoComentario() {
        return textoComentario;
    }

    public void setTextoComentario(String textoComentario) {
        this.textoComentario = textoComentario;
    }
    
    public String addComentario(Socio s, String c, Evento e){
        Comentario c1 = new Comentario();
        
        c1.setEvento(e);
        c1.setFecha(Date.valueOf(LocalDate.now()));
        c1.setTexto(c);
        c1.setSocio(s);
        
        comenEjb.create(c1);
        
        textoComentario= "";
        
        return edu.mostrarEvento(e.getId_evento());
    }

    public String editarCom(Comentario com){
        Long id_evento = com.getEvento().getId_evento();
        comenEjb.edit(com);
        return edu.mostrarEvento(id_evento);
    }

    public String borrarCom(Comentario com){
        Long id_evento = com.getEvento().getId_evento();
        comenEjb.remove(com);
        return edu.mostrarEvento(id_evento);
    }
}
