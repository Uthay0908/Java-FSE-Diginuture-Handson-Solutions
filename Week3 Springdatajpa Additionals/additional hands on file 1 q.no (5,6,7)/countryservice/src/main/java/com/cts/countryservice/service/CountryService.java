package com.cts.countryservice.service;

import com.cts.countryservice.entity.Country;
import com.cts.countryservice.exception.CountryNotFoundException;
import java.util.List;

public interface CountryService {
    Country getCountryByCode(String code);
    Country addCountry(Country country);
    Country updateCountry(Country country);
    void deleteCountry(String code);
    List<Country> searchCountriesByName(String name);
    Country findCountryByCode(String code) throws CountryNotFoundException;
}
