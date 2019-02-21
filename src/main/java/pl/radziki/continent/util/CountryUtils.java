package pl.radziki.continent.util;

import pl.radziki.continent.Main;
import pl.radziki.continent.domain.Country;
import pl.radziki.continent.enums.EContinent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class CountryUtils {

    public static List<Country> getCountriesListFromFile(String fileName) throws URISyntaxException {
        List<Country> countries = new ArrayList<>();
        try {
            Path path = Paths.get(Objects.requireNonNull(Main.class.getClassLoader()
                    .getResource(fileName)).toURI());

            List<String> countryLine = Files.readAllLines(path);
            for (String line : countryLine) {
                Country country = new Country();
                String[] token = line.split(";");
                country.setName(token[0]);
                country.setCapital(token[1]);
                country.setContinent(EContinent.valueOf(token[2]));
                countries.add(country);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return countries;
    }

    public static Map<EContinent, List<Country>> getContinentsMap(List<Country> countries) {
        return countries.stream().collect(Collectors.groupingBy(Country::getContinent));
    }

    public static long countAllCountryStartsWith(List<Country> countries, String startsWith) {
        return countries.stream().filter(x -> x.getName().startsWith(startsWith)).count();
    }

    public static long countAllCountryWithNameOrCapitalStartsWith(List<Country> countries, String prefix) {
        return countries.stream().filter(x -> x.getName().startsWith(prefix) || x.getCapital().startsWith(prefix)).count();
    }

    public static String getTheLongestCapitalName(List<Country> countries) {
         List<String> capitalList = countries.stream().map(Country::getCapital).collect( Collectors.toList());
         return Collections.max(capitalList, Comparator.comparing(String::length));
    }
}
