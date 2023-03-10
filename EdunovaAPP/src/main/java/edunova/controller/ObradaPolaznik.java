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
public class ObradaPolaznik extends Obrada<Polaznik> {

    @Override
    public List<Polaznik> read() {
        return session.createQuery("from Polaznik ", Polaznik.class).list();
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
