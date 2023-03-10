/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.util;

import com.github.javafaker.Faker;
import edunova.model.Grupa;
import edunova.model.Osoba;
import edunova.model.Polaznik;
import edunova.model.Predavac;
import edunova.model.Smjer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.hibernate.Session;

/**
 *
 * @author WinUSER
 */
public class PocetniInsert {

    private static int BROJ_SMJEROVA = 15;
    private static int BROJ_PREDAVACA = 7;
    private static int BROJ_POLAZNIKA = 3000;
    private static int BROJ_GRUPA = 220;
    private static int BROJ_OSOBA = 3007;
    private Faker faker;
    private List<Smjer> smjerovi;
    private List<Osoba> osobe;
    private List<Polaznik> polaznici;
    private List<Predavac> predavaci;
    private Session session;

    public PocetniInsert() {
        faker = new Faker();
        smjerovi = new ArrayList<>();
        osobe = new ArrayList<>();
        polaznici = new ArrayList<>();
        predavaci = new ArrayList<>();
        session = HibernateUtil.getsesSession();
        session.beginTransaction();
        kreirajSmjerove();
        kreirajOsobe();
        kreirajPredavace();
        kreirajPolaznike();
        kreirajGrupe();

        session.getTransaction().commit();

    }

    private void kreirajSmjerove() {
        Smjer s;
        for (int i = 0; i < BROJ_SMJEROVA; i++) {
            s = new Smjer();
            s.setNaziv(faker.app().name());
            s.setCertificiran(faker.bool().bool());
            s.setCijena(new BigDecimal(faker.number().numberBetween(800, 1200)));
            s.setUpisnina(new BigDecimal(faker.number().numberBetween(70, 90)));
            s.setTrajanje(faker.number().numberBetween(90, 230));
            session.persist(s);
            smjerovi.add(s);
        }

    }

    private void kreirajPredavace() {

        Predavac pr;
        for (int i = 0; i < BROJ_PREDAVACA; i++) {
            pr = new Predavac();

            try {
                pr.setOsoba(osobe.get(sb(0, BROJ_OSOBA - 1)));
            } catch (IndexOutOfBoundsException ex) {
                ex.getMessage();
            }

            pr.setIban(faker.business().creditCardNumber());
            session.persist(pr);
            predavaci.add(pr);

        }
    }

    private void kreirajPolaznike() {
        Polaznik p;
        for (int i = 0; i < BROJ_POLAZNIKA; i++) {
            p = new Polaznik();
            try {
                p.setOsoba(osobe.get(sb(0, BROJ_OSOBA - 1)));
            } catch (IndexOutOfBoundsException ex) {
                ex.getMessage();
            }
            p.setBrojUgovora(faker.business().creditCardNumber());
            session.persist(p);
            polaznici.add(p);
        }
    }

    private void kreirajOsobe() {
        Osoba o;
        for (int i = 0; i < BROJ_OSOBA; i++) {
            o = new Osoba();
            o.setIme(faker.name().firstName());
            o.setPrezime(faker.name().lastName());
            o.setEmail(faker.internet().emailAddress());
            o.setOib(Alati.dovuciOib());

            session.persist(o);
            osobe.add(o);
        }
    }

    private void kreirajGrupe() {
        Grupa g;
        List<Polaznik> p;
        for (int i = 0; i < BROJ_GRUPA; i++) {
            g = new Grupa();
            g.setNaziv(faker.beer().name() + " " + (i + 1));
            g.setDatumPocetka(faker.date().birthday(1, 10));
            g.setSmjer(smjerovi.get(sb(0, BROJ_SMJEROVA - 1)));
            g.setPredavac(predavaci.get(sb(0, BROJ_PREDAVACA - 1)));
            p = new ArrayList<>();
            for (int j = 0; j < sb(10, 20); j++) {
                p.add(polaznici.get(sb(0, BROJ_POLAZNIKA - 1)));
            }
            g.setPolaznici(p);
            session.persist(g);
        }
    }

    private int sb(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}
