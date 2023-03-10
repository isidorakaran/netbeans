/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Predavac;
import edunova.util.EdunovaException;
import java.util.List;

/**
 *
 * @author WinUSER
 */
public class ObradaPredavac extends Obrada<Predavac> {

    @Override
    public List<Predavac> read() {
        return session.createQuery("from Predavac", Predavac.class).list();
    }

    @Override
    protected void kontrolaUnos() throws EdunovaException {
        kontrolaUnos(); 
    }

    @Override
    protected void kontrolaPromjena() throws EdunovaException {
       kontrolaPromjena(); 
    }

    @Override
    protected void kontrolaBrisanje() throws EdunovaException {
        kontrolaBrisanje(); 
    }
    
}
