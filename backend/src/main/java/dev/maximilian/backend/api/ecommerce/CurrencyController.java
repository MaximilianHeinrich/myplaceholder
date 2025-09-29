package dev.maximilian.backend.api.ecommerce;

import dev.maximilian.backend.data.service.ecommerce.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/ecommerce/currency")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping("list")
    public String listCurrencies() {
        return "List of currencies";
    }

}
