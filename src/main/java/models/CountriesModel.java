package models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "countries", schema = "public", catalog = "postgres")
public class CountriesModel {
    private int id;
    private String country;
    private String capital;
    private String population;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "capital")
    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @Basic
    @Column(name = "population")
    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountriesModel that = (CountriesModel) o;
        return id == that.id && Objects.equals(country, that.country) && Objects.equals(capital, that.capital) && Objects.equals(population, that.population);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, capital, population);
    }
}
