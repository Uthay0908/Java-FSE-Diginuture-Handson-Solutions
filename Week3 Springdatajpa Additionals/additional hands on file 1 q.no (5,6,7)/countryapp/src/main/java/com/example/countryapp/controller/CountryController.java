package com.example.countryapp.controller;

import com.example.countryapp.entity.Country;
import com.example.countryapp.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {
    private final CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public ResponseEntity<Country> getByCode(@PathVariable String code) {
        return service.findByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Country> search(@RequestParam String name) {
        return service.searchByPartialName(name);
    }

    @PostMapping
    public Country add(@RequestBody Country country) {
        return service.addCountry(country);
    }

    @PutMapping
    public Country update(@RequestBody Country country) {
        return service.updateCountry(country);
    }

    @DeleteMapping("/{code}")
    public void delete(@PathVariable String code) {
        service.deleteCountry(code);
    }

    @GetMapping
    public List<Country> all() {
        return service.getAll();
    }
}
