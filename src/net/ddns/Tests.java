package net.ddns;

public class Tests {
    public static void main(String[] args)  {
        Country country = Country.Poland;
        System.out.println(country.getAbbreviation());
    }
}

enum Country {
    Poland("PL"), Germany("GE"), England("EN");

    String abbreviation;

    Country(String abbreviation)    {
        this.abbreviation = abbreviation;
    }

    String getAbbreviation()    {
        return this.abbreviation;
    }


}