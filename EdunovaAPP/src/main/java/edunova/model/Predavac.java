package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Predavac extends Entitet {
	private String iban;
        @ManyToOne
        private Osoba osoba;
        

	public Predavac() {
		super();
	}

    public Predavac(String iban, Osoba osoba, int sifra) {
        super(sifra);
        this.iban = iban;
        this.osoba = osoba;
    }

    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }

	

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

}
