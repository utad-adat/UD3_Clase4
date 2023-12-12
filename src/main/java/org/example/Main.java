package org.example;

import models.CountriesModel;
import org.hibernate.Session;

import java.util.List;

public class Main {

    private static Session session = null;

    public static void main(String[] args) {
        try {
            session = HibernateUtil.getSession();
            // readCountries();
            // createCountry();

            deleteCountry();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
    }

    private static void deleteCountry() {
        CountriesModel country = session.get(CountriesModel.class, 4);
        session.beginTransaction();
        session.remove(country);
        session.getTransaction().commit();
    }

    private static void createCountry() {
        CountriesModel c = new CountriesModel();
        c.setCountry("Italia");
        c.setCapital("Roma");
        c.setPopulation("900000");

        session.beginTransaction();
        session.persist(c);
        session.getTransaction().commit();
    }

    private static void readCountries() {
        List<CountriesModel> countries = session.createQuery("FROM CountriesModel WHERE capital = :capital", CountriesModel.class)
                .setParameter("capital", "Lisboa")
                .list();

        for (CountriesModel countriesModel : countries) {
            System.out.println("ID: " + countriesModel.getId() + ", Nombre: " + countriesModel.getCountry());
        }
    }


}