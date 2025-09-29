package dev.maximilian.backend.api.ecommerce;

import dev.maximilian.backend.data.service.ecommerce.ECommerceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/ecommerce/products")
@RequiredArgsConstructor
public class ECommerceController {

    private final ECommerceService eCommerceService;

    //TODO: Implement Controller Methods

}
