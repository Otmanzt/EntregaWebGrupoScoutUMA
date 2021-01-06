/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.backingBeans;

import com.softbox.ejb.SocioFacadeLocal;
import com.softbox.entity.Socio;
import com.softbox.exception.CuentaBaja;
import com.softbox.exception.PasswordInvalido;
import com.softbox.exception.ScoutException;
import com.softbox.exception.UsuarioNoExiste;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author migue
 */
@Named(value = "login")
@RequestScoped
public class Login implements Serializable {

    /**
     * Creates a new instance of Login
     */
    @Inject
    private SocioFacadeLocal user;

    private Socio usuario;

    @Inject
    private ControlAutorizacion ctrl;
    
    @Inject
    private notificacionesBB notBB;

    public Login() {
        usuario = new Socio();
    }

    public Socio getUsuario() {
        return usuario;
    }

    public void setUsuario(Socio usuario) {
        this.usuario = usuario;
    }

 
    
    public String autenticar() {
        // Implementar este método
        String cadena = "";
        
        try{
            usuario = user.comprobarLogin(usuario);
            ctrl.setUsuario(usuario);
            notBB.calcularNoLeidas(usuario.getId_Usuario());
            cadena = "index.xhtml";
        }catch(UsuarioNoExiste e){
           FacesMessage fm = new FacesMessage("La cuenta no existe");
           FacesContext.getCurrentInstance().addMessage("login:user", fm);
        }catch(PasswordInvalido e){
            FacesMessage fm = new FacesMessage("La contraseña no es correcta");
            FacesContext.getCurrentInstance().addMessage("login:pass", fm);
        }catch(CuentaBaja e){
            FacesMessage fm = new FacesMessage("La cuenta esta dada de baja, contacta con el administrador");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        }catch(ScoutException e){
            FacesMessage fm = new FacesMessage("Error: " + e);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
       
        return cadena;
    }
}
