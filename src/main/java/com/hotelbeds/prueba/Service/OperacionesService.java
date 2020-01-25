package com.hotelbeds.prueba.Service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbeds.prueba.Repository.DescuentoPedidoRepository;
import com.hotelbeds.prueba.Repository.ImpuestoProvinciaRepository;
import com.hotelbeds.prueba.domain.Comparador;
import com.hotelbeds.prueba.domain.DescuentoPedido;
import com.hotelbeds.prueba.domain.ImpuestoProvincia;

/**
 * The Class OperacionesService.
 */
@Service
public class OperacionesService {
	
	/** The descuento pedido repository. */
	@Autowired
	private final DescuentoPedidoRepository descuentoPedidoRepository;
	
	/** The impuesto provincia repository. */
	@Autowired
	private final ImpuestoProvinciaRepository impuestoProvinciaRepository;
	
	/**
	 * Instantiates a new operaciones service.
	 *
	 * @param descuentoPedidoRepository the descuento pedido repository
	 * @param impuestoProvinciaRepository the impuesto provincia repository
	 */
	public OperacionesService(DescuentoPedidoRepository descuentoPedidoRepository,
			ImpuestoProvinciaRepository impuestoProvinciaRepository) {
        this.descuentoPedidoRepository = descuentoPedidoRepository;
        this.impuestoProvinciaRepository = impuestoProvinciaRepository;
    }

	/**
	 * Method that calculates the value of a product applying discounts and taxes if it has them
	 * We assume that the discount applies if the price exceeds the stipulated limit, that is,
	 * if the price (unit price * quantity) is greater than 1000 we apply 3%, if it is greater than 2000, we apply 7% ...
	 * 
	 * @param Product description
	 * @param Product price
	 * @param product quantity
	 * @param state
	 * @return Total Amount (the big decimal)
	 */
	public BigDecimal calculateTotalAmount(String itemDescription, BigDecimal itemPrice, Integer numberOfItems, String state) {

		// Calculate product total price (price * numberOfItems)
		BigDecimal precioTotal = itemPrice.multiply(new BigDecimal(numberOfItems));
		
		// valorTotal: Total value to return after applying taxes and discounts
		BigDecimal valorTotal = precioTotal;
		
		// We recover the discount types and select the discount to apply
		List<DescuentoPedido> descuentosPedido = descuentoPedidoRepository.findAll();
		descuentosPedido.sort(new Comparador());
		BigDecimal descuentoAplicar = new BigDecimal(0);
		for (DescuentoPedido dp: descuentosPedido) {
			if(precioTotal.compareTo(dp.getValorPedido()) > 0) {
				descuentoAplicar = dp.getDescuento();
			}
		}
		
		// Apply the discount
		valorTotal = valorTotal.subtract(precioTotal.multiply(descuentoAplicar).divide(new BigDecimal(100)));
		
		// We recover the taxes types and select the taxes to apply
		ImpuestoProvincia impuesto = impuestoProvinciaRepository.findByCodProvincia(state);
		if (impuesto != null && impuesto.getImpuesto() != null) {
			valorTotal = valorTotal.add(precioTotal.multiply(impuesto.getImpuesto()).divide(new BigDecimal(100)));
		}
		
		// If the product is tobacco, we add the national tax
		if ("tobacco".equals(itemDescription)) {
			valorTotal = valorTotal.add(precioTotal.multiply(new BigDecimal(0.5)));
		}
		
		return valorTotal;
	}

}
