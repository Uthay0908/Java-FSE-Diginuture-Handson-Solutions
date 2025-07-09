package com.cts.countryservice.service.impl;

import com.cts.countryservice.entity.Country;
import com.cts.countryservice.exception.CountryNotFoundException;
import com.cts.countryservice.repository.CountryRepository;
import com.cts.countryservice.service.CountryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository repository;

    public CountryServiceImpl(CountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Country getCountryByCode(String code) {
        return repository.findById(code).orElse(null);
    }

    @Override
    public Country addCountry(Country country) {
        return repository.save(country);
    }

    @Override
    public Country updateCountry(Country country) {
        return repository.save(country);
    }

    @Override
    public void deleteCountry(String code) {
        repository.deleteById(code);
    }

    @Override
    public List<Country> searchCountriesByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    @Override
    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        Optional<Country> result = repository.findById(countryCode);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found for code: " + countryCode);
        }
        return result.get();
    }
}
