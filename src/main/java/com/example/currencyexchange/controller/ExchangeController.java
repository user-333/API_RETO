package com.example.currencyexchange.controller;
import com.example.currencyexchange.request.ExchangeRequest;
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
    public Map<String, Object> exchange(@RequestBody ExchangeRequest request) {
        Double exchangedAmount = service.applyExchangeRate(request.getSource(), request.getTarget(), request.getAmount());
        return Map.of(
                "monto", request.getAmount(),
                "montoConTipoDeCambio", exchangedAmount,
                "monedaOrigen", request.getSource(),
                "monedaDestino", request.getTarget(),
                "tipoDeCambio", exchangedAmount / request.getAmount()
        );
    }
}
