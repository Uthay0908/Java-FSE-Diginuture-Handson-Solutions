package com.example.countryapp.service;

import com.example.countryapp.entity.Country;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class
CountryService {
    private final com.example.countryapp.repository.CountryRepository repository;

    public CountryService(com.example.countryapp.repository.CountryRepository repository) {
        this.repository = repository;
    }

    public Optional<Country> findByCode(String code) {
        return repository.findById(code);
    }

    public Country addCountry(Country country) {
        return repository.save(country);
    }

    public Country updateCountry(Country country) {
        return repository.save(country);
    }

    public void deleteCountry(String code) {
        repository.deleteById(code);
    }

    public List<Country> searchByPartialName(String name) {
        return repository.findByCoNameContainingIgnoreCase(name);
    }

    public List<Country> getAll() {
        return repository.findAll();
    }
}
