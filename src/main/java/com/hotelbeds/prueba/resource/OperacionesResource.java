package com.hotelbeds.prueba.resource;

import com.hotelbeds.prueba.Service.OperacionesService;

import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OperacionesResource {

    private final Logger log = LoggerFactory.getLogger(OperacionesResource.class);

    @Autowired
    private final OperacionesService operacionesService;

    public OperacionesResource(OperacionesService operacionesService) {
        this.operacionesService = operacionesService;
    }

    @GetMapping("/calculateTotalAmount/{itemDescription}/{itemPrice}/{numberOfItems}/{state}")
	public BigDecimal calculateTotalAmount(@PathVariable String itemDescription, @PathVariable BigDecimal itemPrice, 
			@PathVariable Integer numberOfItems, @PathVariable String state) {
    	BigDecimal valorCalculado = operacionesService.calculateTotalAmount(itemDescription, itemPrice, numberOfItems, state);
		return valorCalculado;
	}
}
