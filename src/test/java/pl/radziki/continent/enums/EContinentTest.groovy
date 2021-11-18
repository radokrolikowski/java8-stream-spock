package pl.radziki.continent.enums;

class EContinentTest extends spock.lang.Specification {

    def "should return EU for Europe continent name"() {
        given:
        final String continent = "Europe";
        when:
        EContinent eContinent = EContinent.fromNameProperty(continent);
        then:
        eContinent == EContinent.EU;
    }

    def "should throw exception for unrecognized continent name"() {
        given:
        final String continent = "Europe2";
        when:
        EContinent eContinent = EContinent.fromNameProperty(continent);
        then:
        thrown(IllegalArgumentException.class);
    }


}
