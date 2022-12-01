
package technicaltask.output;

import java.util.List;

public class Country {

    private String commonName;

    private String officialName;

    private String countryCode;

    private String region;

    private List<BorderCountry> borderCountries;

    public Country() {
    }

    public Country(String commonName, String officialName, String countryCode, String region, List<BorderCountry> borderCountries) {
        this.commonName = commonName;
        this.officialName = officialName;
        this.countryCode = countryCode;
        this.region = region;
        this.borderCountries = borderCountries;
    }

    public List<BorderCountry> getBorders() {
        return borderCountries;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getOfficialName() {
        return officialName;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setBorders(List<BorderCountry> borderCountries) {
        this.borderCountries = borderCountries;
    }
}
