package com.hotelbeds.prueba.domain;

import java.util.Comparator;

/**
 * The Class Comparador.
 */
public class Comparador implements Comparator<DescuentoPedido> {
	  
  	/**
  	 * Compare.
  	 *
  	 * @param p1 the p 1
  	 * @param p2 the p 2
  	 * @return the int
  	 */
  	@Override
	  public int compare(DescuentoPedido p1, DescuentoPedido p2) {
	    return  p1.getValorPedido().compareTo(p2.getValorPedido());
	  }
	}
