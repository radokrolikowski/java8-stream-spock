package pl.radziki.continent.enums;

import java.util.Arrays;

public enum EContinent {
    AF("Africa"),
    EU("Europe"),
    AS("Asia"),
    NA("North America"),
    SA("South America"),
    OC("Australia/Oceania"),
    AN("Antarctica");

    final String name;
    EContinent(String name){
        this.name = name;
    }

    public static EContinent fromNameProperty(String name) {
        return Arrays.stream(values())
                .filter(x -> x.name.equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
