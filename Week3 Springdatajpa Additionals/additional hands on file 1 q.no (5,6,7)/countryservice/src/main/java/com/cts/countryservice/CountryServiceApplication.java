package com.cts.countryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cts.countryservice.service.CountryService;
import com.cts.countryservice.entity.Country;
import com.cts.countryservice.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountryServiceApplication implements CommandLineRunner {

    @Autowired
    private CountryService countryService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CountryServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        getAllCountriesTest();
    }

    private void getAllCountriesTest() {
        LOGGER.info("Start");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Exception: {}", e.getMessage());
        }
        LOGGER.info("End");
    }
}
