/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.ejb;

import com.softbox.entity.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author miguel_martin
 */
@Local
public interface UsuarioFacadeLocal {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);
    
    void comprobarLogin(Usuario u);
    
    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();
    
    Long getNextId();

    
}
