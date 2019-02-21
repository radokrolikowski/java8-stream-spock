package pl.radziki.continent;

import pl.radziki.continent.domain.Country;
import pl.radziki.continent.util.CountryUtils;
import java.net.URISyntaxException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws URISyntaxException {

        final String FILE_NAME = "countries.csv";

        List<Country> countries = CountryUtils.getCountriesListFromFile(FILE_NAME);

        System.out.println(countries);

    }


}
