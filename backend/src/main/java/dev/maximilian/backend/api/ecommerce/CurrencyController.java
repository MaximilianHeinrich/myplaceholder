package dev.maximilian.backend.api.ecommerce;

import dev.maximilian.backend.data.entity.ecommerce.Currency;
import dev.maximilian.backend.data.service.ecommerce.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/ecommerce/currency")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping("findAll")
    public List<Currency> findAllCurrencies() {
        return currencyService.findAllCurrencies();
    }

    @GetMapping("findById")
    public Optional<Currency> findById(@RequestParam Long id) {
        return currencyService.findById(id);
    }

    @GetMapping("findByCode")
    public Optional<Currency> findByCode(@RequestParam String code) {
        return currencyService.findByCode(code);
    }

    @GetMapping("findBySymbol")
    public Optional<Currency> findBySymbol(@RequestParam String symbol) {
        return currencyService.findBySymbol(symbol);
    }

    @GetMapping("findAllCurrencySymbols")
    public List<String> findAllCurrencySymbols() {
        return currencyService.findAllCurrencySymbols();
    }

    @GetMapping("findByIsOnum")
    public List<Currency> findByIsOnum(@RequestParam int isOnum) {
        return currencyService.findByIsOnum(isOnum);
    }

    @GetMapping("findByDecimals")
    public List<Currency> findByDecimals(@RequestParam int decimals) {
        return currencyService.findByDecimals(decimals);
    }

}
