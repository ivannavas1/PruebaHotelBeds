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

/**
 * The Class OperacionesResource.
 */
@RestController
@RequestMapping("/api")
public class OperacionesResource {

    /** The log. */
    private final Logger log = LoggerFactory.getLogger(OperacionesResource.class);

    /** The operaciones service. */
    @Autowired
    private final OperacionesService operacionesService;

    /**
     * Instantiates a new operaciones resource.
     *
     * @param operacionesService the operaciones service
     */
    public OperacionesResource(OperacionesService operacionesService) {
        this.operacionesService = operacionesService;
    }

    /**
     * Method that calculates the value of a product applying discounts and taxes if it has them
     *
     * @param itemDescription the item description
     * @param itemPrice the item price
     * @param numberOfItems the number of items
     * @param state the state
     * @return the big decimal
     */
    @GetMapping("/calculateTotalAmount/{itemDescription}/{itemPrice}/{numberOfItems}/{state}")
	public BigDecimal calculateTotalAmount(@PathVariable String itemDescription, @PathVariable BigDecimal itemPrice, 
			@PathVariable Integer numberOfItems, @PathVariable String state) {
    	BigDecimal valorCalculado = operacionesService.calculateTotalAmount(itemDescription, itemPrice, numberOfItems, state);
		return valorCalculado;
	}
}
