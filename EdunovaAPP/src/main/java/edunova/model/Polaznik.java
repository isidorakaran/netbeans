package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Polaznik extends Entitet {
	private String brojUgovora;
        @ManyToOne
        private Osoba osoba;

    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }

	public Polaznik() {
		super();
	}

    public Polaznik(String brojUgovora, Osoba osoba, int sifra) {
        super(sifra);
        this.brojUgovora = brojUgovora;
        this.osoba = osoba;
    }

	

	public String getBrojUgovora() {
		return brojUgovora;
	}

	public void setBrojUgovora(String brojUgovora) {
		this.brojUgovora = brojUgovora;
	}

}
