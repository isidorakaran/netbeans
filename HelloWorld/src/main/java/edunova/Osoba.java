/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova;

/**
 *
 * @author WinUSER
 */
public class Osoba {
     public Osoba() {
    }

    
    
    private int sifra;
    private String ime;
    private String prezime;
    protected int stats;
    boolean uvjet;

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getStats() {
        return stats;
    }

    public void setStats(int stats) {
        this.stats = stats;
    }

    public boolean isUvjet() {
        return uvjet;
    }

    public void setUvjet(boolean uvjet) {
        this.uvjet = uvjet;
    }
 
}
