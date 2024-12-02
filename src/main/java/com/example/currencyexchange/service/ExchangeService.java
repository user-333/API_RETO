package com.example.currencyexchange.service;

import com.example.currencyexchange.model.ExchangeRate;
import com.example.currencyexchange.repository.ExchangeRateRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExchangeService {

    private final ExchangeRateRepository repository;

    public ExchangeService(ExchangeRateRepository repository) {
        this.repository = repository;
    }

    public Double applyExchangeRate(String source, String target, Double amount) {
        Optional<ExchangeRate> rate = repository.findBySourceCurrencyAndTargetCurrency(source, target);
        if (rate.isEmpty()) {
            throw new IllegalArgumentException("Exchange rate not found.");
        }
        return amount * rate.get().getRate();
    }
}
