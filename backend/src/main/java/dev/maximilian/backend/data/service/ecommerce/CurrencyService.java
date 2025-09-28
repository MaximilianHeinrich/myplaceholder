package dev.maximilian.backend.data.service.ecommerce;

import dev.maximilian.backend.repository.ecommerce.CurrencyRepository;
import dev.maximilian.backend.util.FileMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final FileMapper fileMapper;


}
