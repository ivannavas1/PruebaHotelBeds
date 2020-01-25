package com.hotelbeds.prueba.domain;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The Class DescuentoPedido.
 */
@Entity
public class DescuentoPedido {
	
    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    /** The valor pedido. */
    private BigDecimal valorPedido;
    
    /** The descuento. */
    private BigDecimal descuento;
    
    /**
     * Instantiates a new descuento pedido.
     */
    public DescuentoPedido() {
		super();
	}
    
    /**
     * Instantiates a new descuento pedido.
     *
     * @param id the id
     * @param valorPedido the valor pedido
     * @param descuento the descuento
     */
    public DescuentoPedido(Integer id, BigDecimal valorPedido, BigDecimal descuento) {
		super();
		this.id = id;
		this.valorPedido = valorPedido;
		this.descuento = descuento;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the valor pedido.
	 *
	 * @return the valor pedido
	 */
	public BigDecimal getValorPedido() {
		return valorPedido;
	}

	/**
	 * Sets the valor pedido.
	 *
	 * @param valorPedido the new valor pedido
	 */
	public void setValorPedido(BigDecimal valorPedido) {
		this.valorPedido = valorPedido;
	}

	/**
	 * Gets the descuento.
	 *
	 * @return the descuento
	 */
	public BigDecimal getDescuento() {
		return descuento;
	}

	/**
	 * Sets the descuento.
	 *
	 * @param descuento the new descuento
	 */
	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}
    
}
