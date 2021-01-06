/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.backingBeans;

import com.softbox.ejb.CuotaFacadeLocal;
import com.softbox.entity.Cuota;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


/**
 *
 * @author Tilted-Shugar
 */

@Named(value = "cuotasBB")
@SessionScoped
public class cuotasBB implements Serializable{   
 //   private List<Cuota> cuotas;
    private Cuota cuota = new Cuota();
    
    @Inject
    private CuotaFacadeLocal cuotaEJB;
    
    public cuotasBB(){
    }
    
    public List<Cuota> getCuotas() {
        return cuotaEJB.findAll();
    }

 //   public void setCuotas(List<Cuota> cuotas) {
 //       this.cuotas = cuotas;
 //   }

    public Cuota getCuota() {
        return cuota;
    }

    public void setCuota(Cuota cuota) {
        this.cuota = cuota;
    }
    
    //Accede a la vista de creación de socios
    public String newCuota(){
        cuota = new Cuota();
        return "cuotasCrear.xhtml";
    }
    
    //Crea el socio con los datos proporcionado en la vista de creación
    public String createCuotas(){
        cuota.setId_Cuota(cuotaEJB.getNextId());
        cuotaEJB.create(cuota);
        return "cuotasLista.xhtml";
    }
    public String modCuota(Cuota cuot){
        cuota = cuot;
        return "cuotasModificar.xhtml";
    }
    
    public String updateCuota(){
        cuotaEJB.edit(cuota);
        return "cuotasLista.xhtml";
    }
    
    public String deleteCuota(Cuota cuot){    
        cuotaEJB.remove(cuot);
        return "cuotasLista.xhtml";
    }
}
