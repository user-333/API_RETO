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
        // Agregar impresión de depuración para ver los parámetros de la consulta
        System.out.println("Consultando tipo de cambio para: " + source + " a " + target);
    
        Optional<ExchangeRate> rate = repository.findBySourceCurrencyAndTargetCurrency(source, target);
        
        // Verificar si el resultado de la consulta está vacío y mostrar mensaje de depuración
        if (rate.isEmpty()) {
            System.out.println("Tipo de cambio no encontrado para " + source + " a " + target);
            throw new IllegalArgumentException("Exchange rate not found.");
        }
    
        // Mostrar el tipo de cambio encontrado
        System.out.println("Tipo de cambio encontrado: " + rate.get().getRate());
        return amount * rate.get().getRate();
    }
    
}
