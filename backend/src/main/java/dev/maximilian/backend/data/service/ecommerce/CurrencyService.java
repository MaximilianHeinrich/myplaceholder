package dev.maximilian.backend.data.service.ecommerce;

import dev.maximilian.backend.data.entity.ecommerce.Currency;
import dev.maximilian.backend.repository.ecommerce.CurrencyRepository;
import dev.maximilian.backend.util.FileMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public List<Currency> findAllCurrencies() {
        return currencyRepository.findAll();
    }

    public Optional<Currency> findById(Long id) {
        return currencyRepository.findById(id);
    }

    public Optional<Currency> findByCode(String code) {
        return currencyRepository.findByName(code);
    }

    public Optional<Currency> findBySymbol(String symbol) {
        return currencyRepository.findBySymbol(symbol);
    }

    public List<String> findAllCurrencySymbols() {
        return currencyRepository.findAllCurrencySymbols();
    }

    public List<Currency> findByIsOnum(int isOnum) {
        return currencyRepository.findByIsOnum(isOnum);
    }

    public List<Currency> findByDecimals(int decimals) {
        return currencyRepository.findByDecimals(decimals);
    }

}
