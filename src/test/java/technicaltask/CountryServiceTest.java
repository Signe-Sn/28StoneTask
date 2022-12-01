package technicaltask;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;
import technicaltask.output.BorderCountry;
import technicaltask.output.Country;
import technicaltask.service.CountryService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CountryServiceTest {

    @Spy
    CountryService countryService;

    @Test
    public void testGetBorderCountries() {
        String countryCode = "GB";
        List<BorderCountry> borderCountries = List.of(new BorderCountry("Ireland",
                "Republic of Ireland",
                "IE",
                "Europe",
                null), new BorderCountry("Latvia",
                "Republic of Latvia",
                "LV",
                "Europe",
                null));

        Country country = new Country("United Kingdom",
                "United Kingdom of Great Britain and Northern Ireland",
                "GB",
                "Europe",
                borderCountries);

        Mockito.doReturn(country).when(countryService).getCountry(countryCode);

        List<String> result = List.of("Ireland", "Latvia");

        assertThat(countryService.getBorderCountries(countryCode)).isEqualTo(result);
    }

    @Test
    public void testIfExceptionThrown() {
        String countryCode = "Invalid";
        Mockito.doThrow(WebClientResponseException.NotFound.class).when(countryService).getCountry(countryCode);

        String errorMessage = HttpStatus.NOT_FOUND + " " + "\"Enter a valid Country Code\"";
        Exception exception = assertThrows(ResponseStatusException.class, () ->
                countryService.getBorderCountries(countryCode));

        assertEquals(errorMessage, exception.getMessage());
    }
}

















