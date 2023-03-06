/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Osoba;
import edunova.util.Alati;
import edunova.util.EdunovaException;
import java.util.List;

/**
 *
 * @author WinUSER
 */
public abstract class ObradaOsoba<T extends Osoba>extends Obrada<T>{

    @Override
    protected void kontrolaUnos() throws EdunovaException {
        kontrolaOib();
    }

    @Override
    protected void kontrolaPromjena() throws EdunovaException {
        
    }

    @Override
    protected void kontrolaBrisanje() throws EdunovaException {
        
    }

    private void kontrolaOib()throws EdunovaException {
        if(Alati.kontrolaOib(entitet.getOib())){
            throw new EdunovaException("OIB nije u dobrom formatu");
        }
    }

  
    
}
