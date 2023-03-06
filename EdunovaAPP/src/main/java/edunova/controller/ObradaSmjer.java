/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Smjer;
import edunova.util.EdunovaException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author WinUSER
 */
public class ObradaSmjer extends Obrada<Smjer> {

    @Override
    public List<Smjer> read() {
        return session.createQuery("from Smjer", Smjer.class).list();
    }

    @Override
    protected void kontrolaUnos() throws EdunovaException {
        kontrolaNaziv();
        kontrolaCijena();
    }

    @Override
    protected void kontrolaPromjena() throws EdunovaException {
        kontrolaNazivNull();
        kontrolaNazivNijeBroj();
        kontrolaNazivMinDuzina();
        kontrolaNazivMaxDuzina();
        kontrolaCijena();
    }

    @Override
    protected void kontrolaBrisanje() throws EdunovaException {

    }

    private void kontrolaNaziv() throws EdunovaException {
        kontrolaNazivNull();
        kontrolaNazivNijeBroj();
        kontrolaNazivMinDuzina();
        kontrolaNazivMaxDuzina();
        kontrolaNazivDupliUBazi();

    }

    private void kontrolaNazivNijeBroj() throws EdunovaException {
        boolean broj = false;
        try {
            Double.parseDouble(entitet.getNaziv());
            broj = true;
        } catch (Exception e) {

        }
        if (broj) {
            throw new EdunovaException("Naziv smjera ne smije biti broj");

        }

    }

    private void kontrolaNazivMinDuzina() throws EdunovaException {
        if (entitet.getNaziv().trim().length() < 3) {
            throw new EdunovaException("Naziv smjera mora imati minimalno 3 znaka");
        }

    }

    private void kontrolaNazivNull() throws EdunovaException {
        if (entitet.getNaziv() == null) {
            throw new EdunovaException("Naziv mora biti postavljen");
        }
    }

    private void kontrolaNazivMaxDuzina() throws EdunovaException {
        if (entitet.getNaziv().trim().length() > 50) {
            throw new EdunovaException("Naziv smjera može imati maks 50 znakova");
        }
    }

    private void kontrolaNazivDupliUBazi() throws EdunovaException {
        List<Smjer> smjerovi = null;
        try {
            smjerovi = session.createQuery("from Smjer s " + " where s.naziv=:naziv", Smjer.class)
                    .setParameter("naziv", entitet.getNaziv()).list();
        } catch (Exception e) {
        }
        if (smjerovi != null && !smjerovi.isEmpty()) {
            throw new EdunovaException("Smjer s istim nazivom postoji u bazi");
        }
    }

    private void kontrolaCijena() throws EdunovaException{
        if(entitet.getCijena()==null || 
                entitet.getCijena().compareTo(BigDecimal.ZERO)<=0||
                entitet.getCijena().compareTo(new BigDecimal(10000))==1){
            throw new EdunovaException("Cijena mora biti postavljena, veća od 0 i manja od 10000");
        }
    }

}
