/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softbox.exception;

/**
 *
 * @author miguel_martin
 */
public class ScoutException extends Exception{
    public ScoutException(){
    }
    
    public ScoutException(String msg){
        super(msg);
    }
}
