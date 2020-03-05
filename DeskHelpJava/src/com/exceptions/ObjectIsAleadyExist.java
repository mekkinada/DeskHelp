/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exceptions;

/**
 *
 * @author nadaa
 */
public class ObjectIsAleadyExist extends Exception {

private String errorDetails;

    public ObjectIsAleadyExist(String reason, String errorDetails) {
        super(reason);
        this.errorDetails = errorDetails;
    }

    public ObjectIsAleadyExist() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public String getErrorDetails()
    {
        return errorDetails;
    }
}
