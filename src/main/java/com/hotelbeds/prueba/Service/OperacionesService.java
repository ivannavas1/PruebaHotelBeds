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

@Service
public class OperacionesService {
	
	@Autowired
	private final DescuentoPedidoRepository descuentoPedidoRepository;
	
	@Autowired
	private final ImpuestoProvinciaRepository impuestoProvinciaRepository;
	
	public OperacionesService(DescuentoPedidoRepository descuentoPedidoRepository,
			ImpuestoProvinciaRepository impuestoProvinciaRepository) {
        this.descuentoPedidoRepository = descuentoPedidoRepository;
        this.impuestoProvinciaRepository = impuestoProvinciaRepository;
    }

	public BigDecimal calculateTotalAmount(String itemDescription, BigDecimal itemPrice, Integer numberOfItems, String state) {

		BigDecimal precioTotal = itemPrice.multiply(new BigDecimal(numberOfItems));
		BigDecimal valorTotal = precioTotal;
		List<DescuentoPedido> descuentosPedido = descuentoPedidoRepository.findAll();
		descuentosPedido.sort(new Comparador());
		BigDecimal descuentoAplicar = new BigDecimal(0);
		for (DescuentoPedido dp: descuentosPedido) {
			if(precioTotal.compareTo(dp.getValorPedido()) > 0) {
				descuentoAplicar = dp.getDescuento();
			}
		}
		
		valorTotal = valorTotal.subtract(precioTotal.multiply(descuentoAplicar).divide(new BigDecimal(100)));
		
		ImpuestoProvincia impuesto = impuestoProvinciaRepository.findByCodProvincia(state);
		
		if (impuesto.getImpuesto() != null) {
			valorTotal = valorTotal.add(precioTotal.multiply(impuesto.getImpuesto() == null ? new BigDecimal(0): impuesto.getImpuesto()).divide(new BigDecimal(100)));
		}
		
		if ("tobacco".equals(itemDescription)) {
			valorTotal = valorTotal.add(precioTotal.multiply(new BigDecimal(0.5)));
		}
		
		return valorTotal;
	}

}
