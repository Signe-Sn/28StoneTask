package technicaltask.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;
import technicaltask.output.BorderCountry;
import technicaltask.output.Country;

import java.util.List;

@Service
public class CountryService {

    private final WebClient webClient;

    public CountryService() {
        this.webClient = WebClient.create("https://date.nager.at/api/v3");
    }

    public List<String> getBorderCountries(String countryCode) {
        try {
            return getCountry(countryCode)
                    .getBorders()
                    .stream()
                    .map(BorderCountry::getCommonName)
                    .toList();
        } catch (WebClientResponseException.NotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Enter a valid Country Code");
        }
    }

    public Country getCountry(String countryCode) {
        return webClient.get()
                .uri("/CountryInfo/" + countryCode)
                .retrieve()
                .bodyToMono(Country.class)
                .block();
    }
}





















