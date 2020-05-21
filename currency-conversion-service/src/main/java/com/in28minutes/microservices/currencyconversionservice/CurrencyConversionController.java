package com.in28minutes.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		uriVariables.put("from", from);
		ResponseEntity<CurrencyConversionBean> resEntity = 
		new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables);
		CurrencyConversionBean currencyConversionBean = resEntity.getBody();
		return new CurrencyConversionBean(currencyConversionBean.getId(), from, to, currencyConversionBean.getConversionMultiple(), quantity, quantity.multiply(currencyConversionBean.getConversionMultiple()), currencyConversionBean.getPort());
	}

	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable("from") String from, @PathVariable("to") String to,
				@PathVariable BigDecimal quantity) {
		CurrencyConversionBean currencyConversionBean = proxy.retrieveExchangeValue(from, to);
		return new CurrencyConversionBean(currencyConversionBean.getId(), from, to, currencyConversionBean.getConversionMultiple(), quantity, quantity.multiply(currencyConversionBean.getConversionMultiple()), currencyConversionBean.getPort());
	}
}
