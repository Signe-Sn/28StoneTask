package technicaltask.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technicaltask.service.CountryService;

import java.util.List;

@RestController
@RequestMapping()
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/{countryCode}")
    public List<String> getBorderCountries(@PathVariable String countryCode) {
        return countryService.getBorderCountries(countryCode);
    }

}
