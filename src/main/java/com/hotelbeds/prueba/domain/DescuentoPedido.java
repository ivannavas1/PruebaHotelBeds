package com.hotelbeds.prueba.domain;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DescuentoPedido {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private BigDecimal valorPedido;
    
    private BigDecimal descuento;
    
    public DescuentoPedido() {
		super();
	}
    
    public DescuentoPedido(Integer id, BigDecimal valorPedido, BigDecimal descuento) {
		super();
		this.id = id;
		this.valorPedido = valorPedido;
		this.descuento = descuento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(BigDecimal valorPedido) {
		this.valorPedido = valorPedido;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}
    
}
