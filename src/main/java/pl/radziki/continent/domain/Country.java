package pl.radziki.continent.domain;

import pl.radziki.continent.enums.EContinent;

import java.util.Objects;

public class Country {
    String name;
    String capital;
    EContinent continent;

    public Country() {
    }

    public Country(EContinent continent, String name, String capital) {
        this.continent = continent;
        this.name = name;
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public EContinent getContinent() {
        return continent;
    }

    public void setContinent(EContinent continent) {
        this.continent = continent;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", continent=" + continent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(name, country.name) &&
                Objects.equals(capital, country.capital) &&
                continent == country.continent;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, capital, continent);
    }
}
