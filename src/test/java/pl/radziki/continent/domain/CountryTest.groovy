package pl.radziki.continent.domain

import pl.radziki.continent.enums.EContinent
import pl.radziki.continent.util.CountryUtils

class CountryTest extends spock.lang.Specification {

    final String FILE_NAME = "countries.csv"
    List<Country> countries = CountryUtils.getCountriesListFromFile(FILE_NAME)

    def "is number of continents equals 7"() {
        when:
        Map<EContinent, List<Country>> map = CountryUtils.getContinentsMap(countries)
        then:
        7L == map.entrySet().stream().count()
    }

    def "count and print number of countries starts with Ca"() {
        expect:
        println CountryUtils.countAllCountryStartsWith(countries, "Ca")
    }

    def "count and print number of countries or capitals starts with Ca"() {
        expect:
        println CountryUtils.countAllCountryWithNameOrCapitalStartsWith(countries, "Ca")
    }

    def "print capital with the longest name length"() {
        expect:
        println CountryUtils.getTheLongestCapitalName(countries)
    }

}
