package com.example.currencyexchange.controller;

import com.example.currencyexchange.service.ExchangeService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/exchange")
public class ExchangeController {

    private final ExchangeService service;

    public ExchangeController(ExchangeService service) {
        this.service = service;
    }

    @PostMapping
    public Map<String, Object> exchange(
            @RequestParam String source,
            @RequestParam String target,
            @RequestParam Double amount) {
        Double exchangedAmount = service.applyExchangeRate(source, target, amount);
        return Map.of(
                "monto", amount,
                "montoConTipoDeCambio", exchangedAmount,
                "monedaOrigen", source,
                "monedaDestino", target,
                "tipoDeCambio", exchangedAmount / amount
        );
    }
}
