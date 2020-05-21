package com.in28minutes.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// the name is coming from application.properties of the microservice you want to call.
// url where the currency exchange service is hosted
// @FeignClient(name="currency-exchange-service", url="localhost:8000")
// url not needed with the ribbon client


// change to the zuul pai gateway instead of directly proxying to the microservice.
@FeignClient(name="netflix-zuul-api-gateway-server")
//@FeignClient(name="currency-exchange-service")

// Ribbon is providing load balancing
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}") // <-- for access via Zuul
	//@GetMapping("/currency-exchange/from/{from}/to/{to}") // <-- for direct access.
	// copy it from the CurrencyExchangeController.
	// But this class does not know the ExchangeValue class
	// So change it to CurrencyConversionBean
	public CurrencyConversionBean retrieveExchangeValue
		(@PathVariable String from, @PathVariable String to);
}
