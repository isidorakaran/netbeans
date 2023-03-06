/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Polaznik;
import edunova.util.EdunovaException;
import java.util.List;

/**
 *
 * @author WinUSER
 */
public class ObradaPolaznik extends ObradaOsoba<Polaznik> {

    @Override
    public List<Polaznik> read() {
        return session.createQuery("from Polaznik ", Polaznik.class).list();
    }

    @Override
    protected void kontrolaUnos() throws EdunovaException {
        super.kontrolaUnos(); 
    }

    @Override
    protected void kontrolaPromjena() throws EdunovaException {
        super.kontrolaPromjena(); 
    }

    @Override
    protected void kontrolaBrisanje() throws EdunovaException {
        super.kontrolaBrisanje(); 
    }
    
}
